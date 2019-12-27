package com.eagleeye.ear.models;

import java.util.List;
import java.util.UUID;

public class WingModel {

  private List<UUID> ids;

  public WingModel() {
  }

  public WingModel(List<UUID> ids) {
    this.ids = ids;
  }

  public List<UUID> getIds() {
    return ids;
  }

  public void setIds(List<UUID> ids) {
    this.ids = ids;
  }
}
