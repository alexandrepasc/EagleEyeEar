package com.eagleeye.ear.models;

import com.eagleeye.ear.models.pypiModels.InfoModel;
import com.eagleeye.ear.models.pypiModels.UrlsModel;

import java.util.List;

public class PypiModel {

  private InfoModel info;
  private List<UrlsModel> urls;

  public InfoModel getInfo() {
    return info;
  }

  public void setInfo(InfoModel info) {
    this.info = info;
  }

  public List<UrlsModel> getUrls() {
    return urls;
  }

  public void setUrls(List<UrlsModel> urls) {
    this.urls = urls;
  }
}

