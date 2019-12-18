package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.Feeder;

import java.util.List;
import java.util.UUID;

public interface FeedersDao {

  Feeder getFeederById(UUID id);

  List<Feeder> getFeeders();
}
