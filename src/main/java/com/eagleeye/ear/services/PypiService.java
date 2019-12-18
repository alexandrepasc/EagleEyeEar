package com.eagleeye.ear.services;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PypiService {

  private String host = "pypi.org";
  private String path = "/pypi/";

  public void getPackage(String name)
    throws IOException, URISyntaxException {

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(host)
        .setPath(path + name + "/json")
        .build();
  }
}
