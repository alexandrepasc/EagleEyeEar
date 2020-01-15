package com.eagleeye.ear.impl;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.common.Configuration;
import com.eagleeye.ear.dao.PubdevDao;
import com.eagleeye.ear.models.PubdevModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PubdevDaoImpl implements PubdevDao {

  @Override
  public PubdevModel getPubdevPackByName(String name)
    throws URISyntaxException, IOException {

    ApiUtils apiUtils = new ApiUtils();
    Configuration config = new Configuration();

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(config.getPubdevHost())
        .setPath(config.getPubdevPath() + "/" + name)
        .build();

    String body = apiUtils.apiGet(uri);

    PubdevModel pubdevModel = JsonToObject(body);

    return pubdevModel;
  }

  private PubdevModel JsonToObject(String json)
      throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    PubdevModel pubdevModel = mapper.readValue(json, PubdevModel.class);

    return pubdevModel;
  }
}
