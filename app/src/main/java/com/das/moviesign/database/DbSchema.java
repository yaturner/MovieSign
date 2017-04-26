package com.das.moviesign.database;

/**
 * Created by yaturner on 4/26/2017.
 */

public class DbSchema {

  public static final class MovieTable {
    public final static String NAME = "movie";

    public final static class Cols {
      public final static String ID                  = "Id";
      public final static String POSTER_PATH         = "posterPath";
      public final static String ADULT               = "adult";
      public final static String OVERVIEW            = "overview";
      public final static String RELEASE_DATE        = "releaseDate";
      public final static String GENRE_IDS           = "genreIds";
      public final static String ORIGINAL_TITLE      = "originalTitle";
      public final static String ORIGINAL_LANGUAGE   = "originalLanguage";
      public final static String TITLE               = "title";
      public final static String BACKDROP_PATH       = "backdropPath";
      public final static String POPULARITY          = "popularity";
      public final static String VOTE_COUNT          = "voteCount";
      public final static String VIDEO               = "video";
      public final static String VOTE_AVERAGE        = "voteAverage";
    }
  }
}
