package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.NpmModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface NpmDao {

  NpmModel getNpmPackByName(String name)
    throws URISyntaxException, IOException;
}
