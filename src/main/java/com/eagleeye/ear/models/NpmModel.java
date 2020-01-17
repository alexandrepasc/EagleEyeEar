package com.eagleeye.ear.models;

import com.eagleeye.ear.models.npmModels.DistTagsModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NpmModel {

  private String name;
  @JsonProperty("dist-tags")
  private DistTagsModel distTags;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DistTagsModel getDistTags() {
    return distTags;
  }

  public void setDistTags(DistTagsModel distTags) {
    this.distTags = distTags;
  }
}
