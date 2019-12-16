package com.eagleeye.ear.services;

import com.eagleeye.ear.models.MavenPackage;
import com.fasterxml.jackson.core.JsonProcessingException;
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

public class ReadMaven {

  private String host = "search.maven.org";
  private String path = "/solrsearch/select";

  public void getPackage(String package_id)
      throws IOException, URISyntaxException {

    URI uri = new URIBuilder()
        .setScheme("https")
        .setHost(host)
        .setPath(path)
        .setParameter("q", "id:\"" + package_id + "\"")
        .setParameter("wt", "json")
        .build();

    String body = apiGet(uri);

    MavenPackage mavenPackage = JsonToObject(getContent(body));

    System.out.println(mavenPackage.getId());
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

  private String getContent(String response) {

    String content = response.substring(response.indexOf("\"docs\":") + 8, response.indexOf("]},\"spellcheck\""));

    return content;
  }

  private MavenPackage JsonToObject(String json)
    throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();

    MavenPackage mavenPackage = mapper.readValue(json, MavenPackage.class);

    return mavenPackage;
  }
}
