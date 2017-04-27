package com.das.moviesign;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.das.moviesign.constants.Constants;
import com.das.moviesign.fragments.SearchFragment;
import com.das.moviesign.labs.MovieLab;
import com.das.moviesign.models.GenreModel;
import com.das.moviesign.models.MovieModel;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static MainActivity _instance = null;
  private FragmentManager fragmentManager = null;

  private MovieLab movieLab = null;
  int currentPageNo = -1;
  int totalResults = -1;
  int totalPages = -1;

  public static MainActivity getInstance() {
    return _instance;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    _instance = this;

    movieLab = MovieLab.get(this);

    setContentView(R.layout.activity_main);
    fragmentManager = getSupportFragmentManager();
    SearchFragment searchFragment = SearchFragment.newInstance(null);
    fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, searchFragment, SearchFragment.class.getSimpleName())
            .addToBackStack(SearchFragment.class.getSimpleName())
            .commit();
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  public void getMovieInfo(String title, int pageNo) {
    String request = "https://api.themoviedb.org/3/search/movie?api_key=" +
            Constants.API_V3_TOKEN +
            "&language=en-US&query=" +
            Uri.encode(title) +
            "&page=" +
            pageNo +
            "&include_adult=false";

       Ion.with(this)
            .load(request)
            .asString().setCallback(new FutureCallback<String>() {
      @Override
      public void onCompleted(Exception e, String result) {
        if (result != null) {
          parseMovieJson(result);
        }

      }
    });


  }

  public void parseMovieJson(final String result) {
    ArrayList<GenreModel> genreModelArrayList = new ArrayList<>();

    if (result == null || result.isEmpty()) {
      //TODO error
      return;
    }

    try {
      JSONObject response = new JSONObject(result);
      currentPageNo = response.optInt("page");
      totalResults = response.optInt("total_results");
      totalPages = response.optInt("total_pages");

      JSONArray resultsArray = response.optJSONArray("results");
      if (resultsArray != null && resultsArray.length() > 0) {
        for (int movieIndex = 0; movieIndex < resultsArray.length(); movieIndex++) {
          JSONObject movieObject = resultsArray.optJSONObject(movieIndex);
          boolean adult = movieObject.optBoolean("adult", false);
          String backdropPath = movieObject.optString("backdrop_path", "");
          JSONArray genreArray = movieObject.optJSONArray("genre_ids");
          if (genreArray.length() > 0) {
            for (int index = 0; index < genreArray.length(); index++) {
              int id = genreArray.getInt(0);
              genreModelArrayList.add(new GenreModel(id, ""));
            }
          }
          int id = movieObject.optInt("id");
          String origLanguage = movieObject.optString("original_language", "");
          String origTitle = movieObject.optString("original_title", "");
          String overview = movieObject.optString("overview", "");
          double popularity = movieObject.optDouble("popularity", 0.0);
          String posterPath = movieObject.optString("poster_path", "");
          String releaseDate = movieObject.optString("release_date", "");
          String title = movieObject.optString("title", "");
          boolean video = movieObject.optBoolean("video", false);
          double voteAverage = movieObject.optDouble("vote_average", 0.0);
          int vote_count = movieObject.optInt("vote_count", 0);

          MovieModel movieModel = new MovieModel(id, posterPath, adult, overview, releaseDate, genreModelArrayList, origTitle, origLanguage,
                  title, backdropPath, popularity, vote_count, video, voteAverage);

          movieLab.addMovie(movieModel);
        }
      }
    } catch (JSONException e) {
      //TODO error
      return;
    }
  }
}
