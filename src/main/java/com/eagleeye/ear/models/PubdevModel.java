package com.eagleeye.ear.models;

import com.eagleeye.ear.models.pubdevModels.LatestModel;

public class PubdevModel {

  private String name;
  private LatestModel latest;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LatestModel getLatest() {
    return latest;
  }

  public void setLatest(LatestModel latest) {
    this.latest = latest;
  }
}
