package com.eagleeye.ear.impl;

import com.eagleeye.ear.dao.AuthDao;
import com.eagleeye.ear.models.AuthTokenModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthDaoImpl implements AuthDao {

  @Override
  public AuthTokenModel getToken(String response)
    throws JsonProcessingException {

    return JsonToObject(response);
  }

  private AuthTokenModel JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    AuthTokenModel tokenModel = mapper.readValue(json, AuthTokenModel.class);

    return tokenModel;
  }
}
