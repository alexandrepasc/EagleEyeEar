package com.eagleeye.ear.services;

import com.eagleeye.ear.models.MavenPackage;
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

    //MavenPackage mavenPackage = JsonToObject(getContent(body));

    System.out.println(body);
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
}
