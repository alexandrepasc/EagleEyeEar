package com.eagleeye.ear.service;

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

public class ReadMaven {

  private String host = "search.maven.org";
  private String path = "/solrsearch/select";

  public void getPackage(String package_id)
      throws IOException, URISyntaxException {

    CloseableHttpClient client = HttpClients.createDefault();

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(host)
        .setPath(path)
        .setParameter("q", "id:\"" + package_id + "\"")
        .setParameter("wt", "json")
        .build();

    HttpGet httpGet = new HttpGet(uri);

    CloseableHttpResponse response = client.execute(httpGet);

    ResponseHandler<String> handler = new BasicResponseHandler();
    String body = handler.handleResponse(response);

    assert response.getStatusLine().getStatusCode() == 200;

    client.close();

    System.out.println(body);
  }
}
