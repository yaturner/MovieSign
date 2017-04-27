package com.das.moviesign.models;

import java.io.Serializable;

/**
 * Created by yaturner on 4/27/2017.
 */

public class GenreModel implements Serializable{
  private int id;
  private String name = null;

  public GenreModel(int id, String name)
  {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
