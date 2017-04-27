package com.das.moviesign.labs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.das.moviesign.database.DbCursorWrapper;
import com.das.moviesign.database.DbHelper;
import com.das.moviesign.database.DbSchema;
import com.das.moviesign.models.MovieModel;

import java.util.ArrayList;

/**
 * Created by yaturner on 4/26/2017.
 */

public class MovieLab {
  private static MovieLab movieLab = null;
  
  private Context context = null;
  private SQLiteDatabase db;

  public static MovieLab get(Context context){
    if(movieLab==null){
      movieLab = new MovieLab(context);
    }

    return movieLab;
  }

  private MovieLab(Context context){
    context = context.getApplicationContext();
    db = new DbHelper(context).getWritableDatabase();
  }

  public void addMovie(MovieModel movieModel) {
    ContentValues values = getContentValues(movieModel);
    db.insertWithOnConflict(DbSchema.MovieTable.NAME, null, values, SQLiteDatabase.CONFLICT_REPLACE);
  }

  public void deleteAllMovies()
  {
    db.delete(DbSchema.MovieTable.NAME, null, null);
  }

  public ArrayList<MovieModel> getAllMovies()
  {
    ArrayList<MovieModel> movieModelArrayList = new ArrayList<>();

    DbCursorWrapper cursor = queryMovie(null, null);

    try {
      cursor.moveToFirst();
      while (!cursor.isAfterLast()) {
        movieModelArrayList.add(cursor.getMovie());
        cursor.moveToNext();
      }
    } finally {
      cursor.close();
    }

    return movieModelArrayList;
  }

  private static ContentValues getContentValues(MovieModel movie){
    ContentValues values = new ContentValues();
    values.put(DbSchema.MovieTable.Cols.ID,             movie.getId());
    values.put(DbSchema.MovieTable.Cols.POSTER_PATH,             movie.getPosterPath());
    values.put(DbSchema.MovieTable.Cols.ADULT,             movie.isAdult()?1:0);
    values.put(DbSchema.MovieTable.Cols.OVERVIEW,             movie.getOverview());
    values.put(DbSchema.MovieTable.Cols.RELEASE_DATE,             movie.getReleaseDate());
    values.put(DbSchema.MovieTable.Cols.GENRE_IDS,             movie.getSerializedGenreIds());
    values.put(DbSchema.MovieTable.Cols.ORIGINAL_TITLE,             movie.getOriginalTitle());
    values.put(DbSchema.MovieTable.Cols.ORIGINAL_LANGUAGE,             movie.getOriginalLanguage());
    values.put(DbSchema.MovieTable.Cols.TITLE,             movie.getTitle());
    values.put(DbSchema.MovieTable.Cols.BACKDROP_PATH,             movie.getBackdropPath());
    values.put(DbSchema.MovieTable.Cols.POPULARITY,             movie.getPopularity());
    values.put(DbSchema.MovieTable.Cols.VOTE_COUNT,             movie.getVoteCount());
    values.put(DbSchema.MovieTable.Cols.VIDEO,             movie.isVideo()?1:0);
    values.put(DbSchema.MovieTable.Cols.VOTE_AVERAGE,             movie.getVoteAverage());

    return values;
  }

  private DbCursorWrapper queryMovie(String whereClause, String orderClause){
    Cursor cursor = db.query(
            DbSchema.MovieTable.NAME,
            null,
            whereClause,
            null,
            null,
            null,
            DbSchema.MovieTable.Cols.TITLE+" ASC"
    );

    return new DbCursorWrapper(cursor);
  }
}
