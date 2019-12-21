package com.eagleeye.ear.services;

import com.eagleeye.ear.impl.MavenDaoImpl;
import com.eagleeye.ear.models.MavenModel;

import java.io.IOException;
import java.net.URISyntaxException;

public class MavenService {

  public MavenModel getExternalData(String searchField)
    throws IOException, URISyntaxException {

    MavenDaoImpl mavenDao = new MavenDaoImpl();
    MavenModel mavenModel;

    mavenModel = mavenDao.getMavenPackById(searchField);

    return mavenModel;
  }
}
