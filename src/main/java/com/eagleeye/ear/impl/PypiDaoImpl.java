package com.eagleeye.ear.impl;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.dao.PypiDao;
import com.eagleeye.ear.models.PypiModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class PypiDaoImpl implements PypiDao {

  private String host = "pypi.org";
  private String path = "/pypi/";

  @Override
  public PypiModel getPypiPackByName(String name)
    throws URISyntaxException, IOException {

    ApiUtils apiUtils = new ApiUtils();

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(host)
        .setPath(path + name + "/json")
        .build();

    String body = apiUtils.apiGet(uri);

    PypiModel pypiModel = JsonToObject(body);

    return pypiModel;
  }

  private PypiModel JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    PypiModel pypiModel = mapper.readValue(json, PypiModel.class);

    return pypiModel;
  }
}
