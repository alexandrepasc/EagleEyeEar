package com.eagleeye.ear;

import com.eagleeye.ear.common.Utils;
import com.eagleeye.ear.impl.FeedersDaoImpl;
import com.eagleeye.ear.impl.MavenDaoImpl;
import com.eagleeye.ear.impl.PypiDaoImpl;
import com.eagleeye.ear.models.Feeder;
import com.eagleeye.ear.models.MavenModel;
import com.eagleeye.ear.models.PypiModel;
import com.eagleeye.ear.services.FeedersService;
import com.eagleeye.ear.services.MavenService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;

public class EagleEyeEar {

  public static void main(String[] args) {

    /*--------
    MAVEN API
     --------*/
    MavenDaoImpl mavenDao = new MavenDaoImpl();
    MavenModel mavenModel = new MavenModel();

    try {
      mavenModel = mavenDao.getMavenPackById("org.springframework.boot:spring-boot-starter-security");
    } catch (IOException e) {
      e.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }

    System.out.println(mavenModel.getResponse().getDocs().get(0).getId());
    System.out.println(mavenModel.getResponse().getDocs().get(0).getLatestVersion());
    System.out.println(mavenModel.getResponse().getDocs().get(0).getTimestamp());

    /*--------
    HIBERNATE API
     --------*/
    FeedersDaoImpl feedersDao = new FeedersDaoImpl();

    Feeder feeder = feedersDao.getFeederById(UUID.fromString("d1b60196-b5c7-4be3-ad12-ecd95135802d"));
    System.out.println(feeder.getPackId());

    List<Feeder> feeders = feedersDao.getFeeders();

    for (Feeder feeder1 : feeders) {
      System.out.println(feeder1.getId());
      System.out.println(feeder1.getPackId());
    }

    /*--------
    PYPI API
     --------*/
    PypiDaoImpl pypiDao = new PypiDaoImpl();
    PypiModel pypiModel = new PypiModel();

    try {
      pypiModel = pypiDao.getPypiPackByName("django");
    } catch (URISyntaxException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println(pypiModel.getInfo().getName());
    System.out.println(pypiModel.getInfo().getVersion());
    System.out.println(pypiModel.getUrls().get(0).getUpload_time());
  }

  Utils utils = new Utils();

  private void huntMaven()
      throws IOException, URISyntaxException {

    FeedersService feedersService = new FeedersService();
    MavenService mavenService = new MavenService();

    List<Feeder> feeders = feedersService.getFeeders("maven");

    for (Feeder feeder : feeders) {

      MavenModel mavenModel = mavenService.getExternalData(feeder.getPackId());

      if (utils.isUpdated(feeder.getPackReleaseDate(), mavenModel.getResponse().getDocs().get(0).getTimestamp())) {
        
      }
    }
  }
}
