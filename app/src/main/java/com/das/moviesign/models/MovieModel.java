package com.das.moviesign.models;

import java.util.ArrayList;

/**
 * Created by yaturner on 4/26/2017.
 */

public class MovieModel {
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
