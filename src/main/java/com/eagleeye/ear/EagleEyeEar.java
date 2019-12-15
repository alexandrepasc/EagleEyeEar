package com.eagleeye.ear;

import com.eagleeye.ear.service.ReadMaven;

import java.io.IOException;
import java.net.URISyntaxException;

public class EagleEyeEar {

  public static void main(String[] args) {

    ReadMaven readMaven = new ReadMaven();

    try {
      readMaven.getPackage("org.springframework.boot:spring-boot-starter-security");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
