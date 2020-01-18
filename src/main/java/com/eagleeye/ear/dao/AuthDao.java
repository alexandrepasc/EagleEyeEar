package com.eagleeye.ear.dao;

import com.eagleeye.ear.models.AuthTokenModel;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface AuthDao {

  AuthTokenModel getToken(String response)
    throws JsonProcessingException;
}
