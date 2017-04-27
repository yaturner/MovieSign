package com.das.moviesign.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.das.moviesign.MainActivity;
import com.das.moviesign.R;
import com.das.moviesign.adapters.MovieResultsAdapter;
import com.das.moviesign.constants.Constants;
import com.das.moviesign.labs.MovieLab;
import com.das.moviesign.models.MovieModel;

import java.util.ArrayList;

/**
 * Created by yaturner on 4/27/2017.
 */

public class ResultsFragment extends Fragment 
  implements AdapterView.OnItemClickListener
{
  private final static String TAG = ResultsFragment.class.getSimpleName();

  private static ResultsFragment fragment = null;
  private MainActivity mainActivity = MainActivity.getInstance();

  private FragmentManager fragmentManager = null;

  private MovieLab movieLab = null;

  private MovieResultsAdapter movieResultsAdapter = null;

  private View view = null;
  private ListView listView = null;

  private ArrayList<MovieModel> movieModelArrayList = null;

  public static ResultsFragment newInstance(Bundle bundle) {
    ResultsFragment fragment = new ResultsFragment();
    fragment.fragment = fragment;
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    fragmentManager = getActivity().getSupportFragmentManager();
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    movieLab = MovieLab.get(mainActivity);
    movieModelArrayList = movieLab.getAllMovies();

    view = inflater.inflate(R.layout.results_fragment, container, false);
    listView = (ListView) view.findViewById(R.id.results_listview);
    movieResultsAdapter = new MovieResultsAdapter(getActivity(), R.layout.results_listitem, movieModelArrayList );
    listView.setAdapter(movieResultsAdapter);
    listView.setOnItemClickListener(this);

    return view;
  }

    @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    MovieModel movieModel = movieModelArrayList.get(i);
      Bundle bundle = new Bundle();
      bundle.putSerializable(Constants.ARG_SELECTED_MOVIE, movieModel);
      DetailsFragment fragment = DetailsFragment.newInstance(bundle);
      fragmentManager.beginTransaction()
              .replace(R.id.fragment_container, fragment, DetailsFragment.class.getSimpleName())
              .addToBackStack(DetailsFragment.class.getSimpleName())
              .commit();
  }
}
