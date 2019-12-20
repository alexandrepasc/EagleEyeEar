package com.eagleeye.ear.impl;

import com.eagleeye.ear.dao.MavenDao;
import com.eagleeye.ear.models.MavenModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MavenDaoImpl implements MavenDao {

  private String host = "search.maven.org";
  private String path = "/solrsearch/select";

  @Override
  public MavenModel getMavenPackById(String id) {
    return null;
  }

  private MavenModel JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    MavenModel mavenModel = mapper.readValue(json, MavenModel.class);

    return mavenModel;
  }
}
