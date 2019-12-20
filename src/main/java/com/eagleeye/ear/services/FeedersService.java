package com.eagleeye.ear.services;

import com.eagleeye.ear.impl.FeedersDaoImpl;
import com.eagleeye.ear.models.Feeder;

import java.util.List;

public class FeedersService {

  public List<Feeder> getFeeders(String repository) {

    FeedersDaoImpl feedersDao = new FeedersDaoImpl();

    List<Feeder> feeders = feedersDao.getFeedersByRepo(repository);

    return feeders;
  }

  public void updateFeeder(Feeder feeder, String version, long timeStamp) {

    Feeder newFeeder = feeder;

    newFeeder.setPackVersion(version);
    newFeeder.setPackReleaseDate(timeStamp);

    FeedersDaoImpl feedersDao = new FeedersDaoImpl();

    feedersDao.updateFeeder(newFeeder);
  }
}
