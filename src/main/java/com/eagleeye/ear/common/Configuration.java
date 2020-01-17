package com.eagleeye.ear.common;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {

  public String getWingUrl() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("wing.url");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getWingUsername() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("wing.username");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getWingPassword() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("wing.password");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getPubdevHost() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("pubdev.host");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getPubdevPath() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("pubdev.path");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public String getNpmHost() {

    try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

      Properties properties = new Properties();

      if (input == null) {
        return null;
      }

      properties.load(input);

      return properties.getProperty("npm.host");

    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
