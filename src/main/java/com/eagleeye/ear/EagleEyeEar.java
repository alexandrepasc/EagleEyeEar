package com.eagleeye.ear;

import com.eagleeye.ear.common.Repository;
import com.eagleeye.ear.common.Utils;
import com.eagleeye.ear.models.Feeder;
import com.eagleeye.ear.models.MavenModel;
import com.eagleeye.ear.models.PubdevModel;
import com.eagleeye.ear.models.PypiModel;
import com.eagleeye.ear.services.FeedersService;
import com.eagleeye.ear.services.MavenService;
import com.eagleeye.ear.services.PubdevService;
import com.eagleeye.ear.services.PypiService;
import com.eagleeye.ear.services.WingAuthService;
import com.eagleeye.ear.services.WingService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EagleEyeEar {

  public static void main(String[] args) {

    String token = null;
    try {
      token = getToken();
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (token != null) {

      try {
        huntMaven(token);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }

      try {
        huntPypi(token);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      }

      try {
        huntPubdev(token);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (URISyntaxException e) {
        e.printStackTrace();
      }

    } else {
      System.out.println("ERROR: No auth token.");
    }
  }

  private static void huntMaven(String token)
    throws IOException, URISyntaxException {

    FeedersService feedersService = new FeedersService();
    MavenService mavenService = new MavenService();
    Utils utils = new Utils();

    List<Feeder> feeders = feedersService.getFeeders(Repository.MAVEN.getName());

    List<UUID> updatedFeeders = new ArrayList<>();

    for (Feeder feeder : feeders) {

      MavenModel mavenModel = mavenService.getExternalData(feeder.getPackId());

      if (utils.isUpdated(feeder.getPackReleaseDate(), mavenModel.getResponse().getDocs().get(0).getTimestamp())) {

        feedersService.updateFeeder(
            feeder,
            mavenModel.getResponse().getDocs().get(0).getLatestVersion(),
            mavenModel.getResponse().getDocs().get(0).getTimestamp()
        );

        updatedFeeders.add(feeder.getId());
      }
    }

    WingService wingService = new WingService();
    String response = wingService.sendActivation(updatedFeeders, token);
  }

  private static void huntPypi(String token)
    throws IOException, URISyntaxException, ParseException {

    FeedersService feedersService = new FeedersService();
    PypiService pypiService = new PypiService();
    Utils utils = new Utils();

    List<Feeder> feeders = feedersService.getFeeders(Repository.PYPI.getName());

    List<UUID> updatedFeeders = new ArrayList<>();

    for (Feeder feeder : feeders) {

      PypiModel pypiModel = pypiService.getExternalData(feeder.getPackName());

      if (utils.isUpdated(feeder.getPackReleaseDate(), pypiService.convertDateToMillis(pypiModel.getUrls().get(1).getUpload_time()))) {

        feedersService.updateFeeder(
            feeder,
            pypiModel.getInfo().getVersion(),
            pypiService.convertDateToMillis(pypiModel.getUrls().get(1).getUpload_time())
        );

        updatedFeeders.add(feeder.getId());
      }
    }

    WingService wingService = new WingService();
    String response = wingService.sendActivation(updatedFeeders, token);
  }

  private static void huntPubdev(String token)
    throws IOException, URISyntaxException {

    FeedersService feedersService = new FeedersService();
    PubdevService pubdevService = new PubdevService();
    Utils utils = new Utils();

    List<Feeder> feeders = feedersService.getFeeders(Repository.PUBDEV.getName());

    List<UUID> updatedFeeders = new ArrayList<>();

    for (Feeder feeder : feeders) {

      PubdevModel pubdevModel = pubdevService.getExternalData(feeder.getPackName());

      if (utils.isUpdated(feeder.getPackVersion(), pubdevModel.getLatest().getVersion())) {

        feedersService.updateFeeder(
            feeder,
            pubdevModel.getLatest().getVersion()
        );

        updatedFeeders.add(feeder.getId());
      }
    }

    if (updatedFeeders.size() > 0) {
      WingService wingService = new WingService();
      String response = wingService.sendActivation(updatedFeeders, token);
    }
  }

  private static String getToken()
    throws IOException {

    WingAuthService authService = new WingAuthService();

    return authService.getAuthToken();
  }
}
