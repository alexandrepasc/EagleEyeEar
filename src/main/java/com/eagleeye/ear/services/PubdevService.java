package com.eagleeye.ear.services;

import com.eagleeye.ear.impl.PubdevDaoImpl;
import com.eagleeye.ear.models.PubdevModel;

import java.io.IOException;
import java.net.URISyntaxException;

public class PubdevService {

  public PubdevModel getExternalData(String searchField)
    throws IOException, URISyntaxException {

    PubdevDaoImpl pubdevDao = new PubdevDaoImpl();
    PubdevModel pubdevModel;

    pubdevModel = pubdevDao.getPubdevPackByName(searchField);

    return pubdevModel;
  }
}
