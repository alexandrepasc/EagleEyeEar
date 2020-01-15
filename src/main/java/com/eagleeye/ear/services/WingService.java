package com.eagleeye.ear.services;

import com.eagleeye.ear.common.ApiUtils;
import com.eagleeye.ear.common.Configuration;
import com.eagleeye.ear.models.WingModel;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WingService {

  public String sendActivation(List<UUID> ids, String token)
    throws IOException {

    Configuration config = new Configuration();

    Map<String, String> header = getHeader(token);

    StringEntity body = getBody(ids);

    ApiUtils apiUtils = new ApiUtils();

    System.out.println("Send request.");

    String response = apiUtils.apiPost(config.getWingUrl() + "activate", header, body);

    return response;
  }

  private Map<String, String> getHeader(String token) {

    Map<String, String> header = new HashMap<>();

    header.put("Content-Type", "application/json");
    header.put("Authorization", "Bearer " + token);

    return header;
  }

  private StringEntity getBody(List<UUID> ids) {

    try {

      WingModel wing = buildModel(ids);

      String json = new ObjectMapper().writeValueAsString(wing);

      return new StringEntity(json);

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private WingModel buildModel(List<UUID> ids) {

    WingModel wingModel = new WingModel(
        ids
    );

    return wingModel;
  }
}
