package com.das.moviesign.models;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by yaturner on 4/26/2017.
 */

public class MovieModel {
  private final static String TAG = MovieModel.class.getSimpleName();

  private int id;
  private String posterPath = null;
  private boolean adult;
  private String overview = null;
  private String releaseDate = null;
  private ArrayList<String> genreIds = null;
  private String originalTitle = null;
  private String originalLanguage = null;
  private String title = null;
  private String backdropPath = null;
  private int popularity;
  private int voteCount;
  private boolean video;
  private int voteAverage;

  public MovieModel(
          int id,
          String posterPath,
          boolean adult,
          String overview,
          String releaseDate,
          ArrayList<String> genreIds,
          String originalTitle,
          String originalLanguage,
          String title,
          String backdropPath,
          int popularity,
          int voteCount,
          boolean video,
          int voteAverage
  ) {
    this.id = id;
    this.posterPath = posterPath;
    this.adult = adult;
    this.overview = overview;
    this.releaseDate = releaseDate;
    this.genreIds = genreIds;
    this.originalTitle = originalTitle;
    this.originalLanguage = originalLanguage;
    this.title = title;
    this.backdropPath = backdropPath;
    this.popularity = popularity;
    this.voteCount = voteCount;
    this.video = video;
    this.voteAverage = voteAverage;
  }

  public MovieModel(
          int id,
          String posterPath,
          boolean adult,
          String overview,
          String releaseDate,
          byte[] genreIds,
          String originalTitle,
          String originalLanguage,
          String title,
          String backdropPath,
          int popularity,
          int voteCount,
          boolean video,
          int voteAverage
  ) {
    this.id = id;
    this.posterPath = posterPath;
    this.adult = adult;
    this.overview = overview;
    this.releaseDate = releaseDate;
    setGenreIds(genreIds);
    this.originalTitle = originalTitle;
    this.originalLanguage = originalLanguage;
    this.title = title;
    this.backdropPath = backdropPath;
    this.popularity = popularity;
    this.voteCount = voteCount;
    this.video = video;
    this.voteAverage = voteAverage;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public ArrayList<String> getGenreIds() {
    return genreIds;
  }

  public void setGenreIds(ArrayList<String> genreIds) {
    this.genreIds = genreIds;
  }

  public byte[] getSerializedGenreIds() {
// Serialize data object to a byte array
    try {
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      ObjectOutputStream os = new ObjectOutputStream(out);
      os.writeObject(genreIds);
      return out.toByteArray();
    } catch (IOException e) {
      Log.d(TAG, e.getMessage());
    }
    return null;
  }

  public void setGenreIds(byte[] genreBytes) {
    genreIds = new ArrayList<String>();
    if (genreBytes != null&& genreBytes.length > 0) {
      ByteArrayInputStream in = new ByteArrayInputStream(genreBytes);
      ObjectInputStream is = null;
      try {
        is = new ObjectInputStream(in);
      } catch (IOException e) {
        e.printStackTrace();
      }
      try {
        genreIds = (ArrayList<String>)is.readObject();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public String getOriginalTitle() {
    return originalTitle;
  }

  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  public String getOriginalLanguage() {
    return originalLanguage;
  }

  public void setOriginalLanguage(String originalLanguage) {
    this.originalLanguage = originalLanguage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public int getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(int voteCount) {
    this.voteCount = voteCount;
  }

  public boolean isVideo() {
    return video;
  }

  public void setVideo(boolean video) {
    this.video = video;
  }

  public int getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(int voteAverage) {
    this.voteAverage = voteAverage;
  }
}
