package com.eagleeye.ear.impl;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.dao.MavenDao;
import com.eagleeye.ear.models.MavenModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MavenDaoImpl implements MavenDao {

  private String host = "search.maven.org";
  private String path = "/solrsearch/select";

  @Override
  public MavenModel getMavenPackById(String id)
    throws URISyntaxException, IOException {

    ApiUtils apiUtils = new ApiUtils();

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(host)
        .setPath(path)
        .setParameter("q", "id:\"" + id + "\"")
        .setParameter("wt", "json")
        .build();

    String body = apiUtils.apiGet(uri);

    MavenModel mavenModel = JsonToObject(body);

    return mavenModel;
  }

  private MavenModel JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    MavenModel mavenModel = mapper.readValue(json, MavenModel.class);

    return mavenModel;
  }
}
