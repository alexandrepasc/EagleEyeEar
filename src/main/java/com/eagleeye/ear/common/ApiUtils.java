package com.eagleeye.ear.common;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class ApiUtils {

  public String apiGet(URI uri)
    throws IOException {

    CloseableHttpClient client = HttpClients.createDefault();

    HttpGet httpGet = new HttpGet(uri);

    CloseableHttpResponse response = client.execute(httpGet);

    ResponseHandler<String> handler = new BasicResponseHandler();
    String body = handler.handleResponse(response);

    assert response.getStatusLine().getStatusCode() == 200;

    client.close();

    return body;
  }

  public String apiPost(String url, Map<String, String> header, StringEntity body)
    throws IOException {

    CloseableHttpClient client = HttpClients.createDefault();

    HttpPost httpPost = new HttpPost(url);

    for (String key : header.keySet()) {
      httpPost.addHeader(key, header.get(key));
    }

    httpPost.setEntity(body);

    CloseableHttpResponse response = client.execute(httpPost);

    ResponseHandler<String> handler = new BasicResponseHandler();
    String responseBody = handler.handleResponse(response);

    client.close();

    return responseBody;
  }
}
