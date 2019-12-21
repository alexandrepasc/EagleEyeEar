package com.eagleeye.ear.common;

public class Utils {

  public boolean isUpdated(long feeder, long external) {

    if (feeder < external) {
      return true;
    } else {
      return false;
    }
  }
}
