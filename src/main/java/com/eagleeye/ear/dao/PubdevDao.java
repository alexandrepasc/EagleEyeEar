package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.PubdevModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface PubdevDao {

  PubdevModel getPubdevPackByName(String name)
      throws URISyntaxException, IOException;
}
