package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.MavenModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface MavenDao {

  MavenModel getMavenPackById(String id)
      throws URISyntaxException, IOException;
}
