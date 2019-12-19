package com.eagleeye.ear.models;

import com.eagleeye.ear.models.pypiModels.InfoModel;
import com.eagleeye.ear.models.pypiModels.UrlsModel;

public class PypiModel {

  private InfoModel info;
  private UrlsModel urls;

  public InfoModel getInfo() {
    return info;
  }

  public void setInfo(InfoModel info) {
    this.info = info;
  }

  public UrlsModel getUrls() {
    return urls;
  }

  public void setUrls(UrlsModel urls) {
    this.urls = urls;
  }
}

