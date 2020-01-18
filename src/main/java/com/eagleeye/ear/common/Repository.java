package com.eagleeye.ear.common;

public enum Repository {
  MAVEN("maven"),
  PYPI("pypi"),
  PUBDEV("pubdev"),
  NPM("npm");

  private String name;

  public String getName() {
    return name;
  }

  Repository(String name) {
    this.name = name;
  }
}
