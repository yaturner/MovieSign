package com.das.moviesign.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.das.moviesign.models.MovieModel;

import java.util.ArrayList;

/**
 * Created by yaturner on 4/26/2017.
 */

public class DbCursorWrapper extends CursorWrapper {
  public DbCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public MovieModel getMovie()
  {

    int id = getInt(getColumnIndex(DbSchema.MovieTable.Cols.ID));
    String posterPath = getString(getColumnIndex(DbSchema.MovieTable.Cols.POSTER_PATH));
    boolean adult = (getInt(getColumnIndex(DbSchema.MovieTable.Cols.ADULT)) == 1);
    String overview = getString(getColumnIndex(DbSchema.MovieTable.Cols.OVERVIEW));
    String releaseDate = getString(getColumnIndex(DbSchema.MovieTable.Cols.RELEASE_DATE));
    byte[] genres = getBlob(getColumnIndex(DbSchema.MovieTable.Cols.GENRE_IDS));
    String originalTitle  = getString(getColumnIndex(DbSchema.MovieTable.Cols.ORIGINAL_TITLE));
    String originalLanguage  = getString(getColumnIndex(DbSchema.MovieTable.Cols.ORIGINAL_LANGUAGE));
    String title  = getString(getColumnIndex(DbSchema.MovieTable.Cols.TITLE));
    String backdropPath  = getString(getColumnIndex(DbSchema.MovieTable.Cols.BACKDROP_PATH));
    int popularity = getInt(getColumnIndex(DbSchema.MovieTable.Cols.POPULARITY));
    int voteCount = getInt(getColumnIndex(DbSchema.MovieTable.Cols.VOTE_COUNT));
    boolean video = (getInt(getColumnIndex(DbSchema.MovieTable.Cols.VIDEO)) == 1);
    int voteAverage = getInt(getColumnIndex(DbSchema.MovieTable.Cols.VOTE_AVERAGE));;

    MovieModel movieModel = new MovieModel(id, posterPath, adult, overview, releaseDate, genres, originalTitle, originalLanguage,
            title, backdropPath, popularity, voteCount, video, voteAverage);

    return movieModel;
  }
}
