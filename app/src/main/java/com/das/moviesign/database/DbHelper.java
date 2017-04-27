package com.das.moviesign.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yaturner on 4/26/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

  private static final int VERSION = 1;
  private static final String DATABASE_NAME = "movie.db";

  private static final String create_string = "create table if not exists ";
  private static final String INTEGER_KEY = " INTEGER PRIMARY KEY, ";
  private static final String INTEGER = " INTEGER, ";
  private static final String VARCHAR = " VARCHAR, ";
  private static final String BLOB = " BLOB, ";

  public DbHelper(Context context) {
    super(context, DATABASE_NAME, null, VERSION);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(create_string + DbSchema.MovieTable.NAME + "("
            + DbSchema.MovieTable.Cols.ID + " INTEGER PRIMARY KEY, "
            + DbSchema.MovieTable.Cols.POSTER_PATH + " TEXT, "
            + DbSchema.MovieTable.Cols.ADULT + INTEGER
            + DbSchema.MovieTable.Cols.OVERVIEW  + " TEXT, "
            + DbSchema.MovieTable.Cols.RELEASE_DATE + " TEXT, "
            + DbSchema.MovieTable.Cols.GENRE_IDS + BLOB
            + DbSchema.MovieTable.Cols.ORIGINAL_TITLE + " TEXT, "
            + DbSchema.MovieTable.Cols.ORIGINAL_LANGUAGE + " TEXT, "
            + DbSchema.MovieTable.Cols.TITLE + " TEXT, "
            + DbSchema.MovieTable.Cols.BACKDROP_PATH + " TEXT, "
            + DbSchema.MovieTable.Cols.POPULARITY + " DOUBLE, "
            + DbSchema.MovieTable.Cols.VOTE_COUNT + INTEGER
            + DbSchema.MovieTable.Cols.VIDEO + INTEGER
            + DbSchema.MovieTable.Cols.VOTE_AVERAGE + " DOUBLE "
                    + ")");
  }

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

  }
}
