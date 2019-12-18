package com.eagleeye.ear;

import com.eagleeye.ear.impl.FeedersDaoImpl;
import com.eagleeye.ear.models.Feeder;
import com.eagleeye.ear.services.ReadMaven;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

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

    FeedersDaoImpl feedersDao = new FeedersDaoImpl();

    Feeder feeder = feedersDao.getFeederById(UUID.fromString("d1b60196-b5c7-4be3-ad12-ecd95135802d"));
    System.out.println(feeder.getPackId());

    List<Feeder> feeders = feedersDao.getFeeders();

    for (Feeder feeder1 : feeders) {
      System.out.println(feeder1.getId());
      System.out.println(feeder1.getPackId());
    }
  }
}
