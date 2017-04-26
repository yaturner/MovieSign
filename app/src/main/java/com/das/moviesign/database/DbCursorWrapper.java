package com.das.moviesign.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.das.moviesign.models.MovieModel;

/**
 * Created by yaturner on 4/26/2017.
 */

public class DbCursorWrapper extends CursorWrapper {
  public DbCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public MovieModel getMovie()
  {
    MovieModel movieModel = null;


    return movieModel;
  }
}
