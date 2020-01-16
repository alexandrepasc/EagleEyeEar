package com.eagleeye.ear.services;

import com.eagleeye.ear.impl.NpmDaoImpl;
import com.eagleeye.ear.models.NpmModel;

import java.io.IOException;
import java.net.URISyntaxException;

public class NpmService {

  public NpmModel getExternalData(String searchField)
    throws IOException, URISyntaxException {

    NpmDaoImpl npmDao = new NpmDaoImpl();
    NpmModel npmModel;

    npmModel = npmDao.getNpmPackByName(searchField);

    return npmModel;
  }
}
