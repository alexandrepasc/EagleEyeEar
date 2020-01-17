package com.eagleeye.ear.impl;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.common.Configuration;
import com.eagleeye.ear.dao.NpmDao;
import com.eagleeye.ear.models.NpmModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class NpmDaoImpl implements NpmDao {

  @Override
  public NpmModel getNpmPackByName(String name)
    throws URISyntaxException, IOException {

    ApiUtils apiUtils = new ApiUtils();
    Configuration config = new Configuration();

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(config.getNpmHost())
        .setPath(name)
        .build();

    String body = apiUtils.apiGet(uri);

    NpmModel npmModel = JsonToObject(body);

    return npmModel;
  }

  private NpmModel JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    NpmModel npmModel = mapper.readValue(json, NpmModel.class);

    return npmModel;
  }
}
