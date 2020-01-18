package com.eagleeye.ear.services;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.common.Configuration;
import com.eagleeye.ear.impl.AuthDaoImpl;
import com.eagleeye.ear.models.AuthTokenModel;
import com.eagleeye.ear.models.WingAuthModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WingAuthService {

  public String getAuthToken()
    throws IOException {

    Configuration config = new Configuration();

    Map<String, String> header = getHeader();

    StringEntity body = getBody(config);

    ApiUtils apiUtils = new ApiUtils();

    String response = apiUtils.apiPost(config.getWingUrl() + "auth", header, body);

    AuthDaoImpl authDao = new AuthDaoImpl();

    AuthTokenModel tokenModel = authDao.getToken(response);

    return tokenModel.getToken();
  }

  private Map<String, String> getHeader() {

    Map<String, String> header = new HashMap<>();

    header.put("Content-Type", "application/json");

    return header;
  }

  private StringEntity getBody(Configuration config) {

    try {
      WingAuthModel auth = buildModel(config.getWingUsername(), config.getWingPassword());

      String json = new ObjectMapper().writeValueAsString(auth);

      return new StringEntity(json);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private WingAuthModel buildModel(String username, String password) {

    WingAuthModel wingAuthModel = new WingAuthModel(
        username,
        password
    );

    return wingAuthModel;
  }
}
