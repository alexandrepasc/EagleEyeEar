package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.PypiModel;

import java.io.IOException;
import java.net.URISyntaxException;

public interface PypiDao {

  PypiModel getPypiPackByName(String name)
    throws URISyntaxException, IOException;
}
