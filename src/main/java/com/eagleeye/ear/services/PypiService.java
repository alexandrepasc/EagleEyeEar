package com.eagleeye.ear.services;

import com.eagleeye.ear.impl.PypiDaoImpl;
import com.eagleeye.ear.models.PypiModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PypiService {

  public PypiModel getExternalData(String searchField)
    throws IOException, URISyntaxException {

    PypiDaoImpl pypiDao = new PypiDaoImpl();
    PypiModel pypiModel = new PypiModel();

    pypiModel = pypiDao.getPypiPackByName(searchField);

    return pypiModel;
  }

  public long convertDateToMillis(String stringDate)
    throws ParseException {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    Date timeStamp = format.parse(stringDate);
    long timeStampMillis = timeStamp.getTime();

    return timeStampMillis;
  }
}
