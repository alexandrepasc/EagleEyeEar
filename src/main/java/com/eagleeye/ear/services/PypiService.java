package com.eagleeye.ear.services;

import com.eagleeye.ear.models.PypiModel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

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

    String body = apiGet(uri);

    PypiModel pypiModel = JsonToObject(body);

    System.out.println(pypiModel.getInfo().getName());
    System.out.println(pypiModel.getInfo().getVersion());
    System.out.println(pypiModel.getUrls().get(0).getUpload_time());
  }

  private String apiGet(URI uri)
      throws IOException, URISyntaxException {

    CloseableHttpClient client = HttpClients.createDefault();

    HttpGet httpGet = new HttpGet(uri);

    CloseableHttpResponse response = client.execute(httpGet);

    ResponseHandler<String> handler = new BasicResponseHandler();
    String body = handler.handleResponse(response);

    assert response.getStatusLine().getStatusCode() == 200;

    client.close();

    return body;
  }

  private PypiModel JsonToObject(String json)
      throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    PypiModel pypiModel = mapper.readValue(json, PypiModel.class);

    return pypiModel;
  }
}
