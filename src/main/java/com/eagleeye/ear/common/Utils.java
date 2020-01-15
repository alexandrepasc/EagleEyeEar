package com.eagleeye.ear.common;

public class Utils {

  public boolean isUpdated(long feeder, long external) {

    if (feeder < external) {
      return true;
    } else {
      return false;
    }
  }

  //TODO: HANDLE THE NULL IF IT IS NULL SHOULD NOT RETURN TRUE
  public  boolean isUpdated(String feeder, String external) {

    if (external != null) {

      if (!feeder.equals(external)) {
        return true;
      } else {
        return false;
      }

    } else {
      return true;
    }
  }
}
