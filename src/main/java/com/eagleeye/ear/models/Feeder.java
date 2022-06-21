package com.eagleeye.ear.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "feeders")
public class Feeder {

  @Id
  //@GeneratedValue(generator = "UUID")
  //@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  //@Type(type="java.util.UUID")
  @Column(name = "id")
  private UUID id;
  @Column(name = "pack_name")
  private String packName;
  @Column(name = "pack_id")
  private String packId;
  @Column(name = "pack_group")
  private String packGroup;
  @Column(name = "pack_artifact")
  private String packArtifact;
  @Column(name = "pack_version")
  private String packVersion;
  @Column(name = "pack_release_date")
  private long packReleaseDate;
  @Column(name = "repository")
  private String repository;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getPackName() {
    return packName;
  }

  public void setPackName(String packName) {
    this.packName = packName;
  }

  public String getPackId() {
    return packId;
  }

  public void setPackId(String packId) {
    this.packId = packId;
  }

  public String getPackGroup() {
    return packGroup;
  }

  public void setPackGroup(String packGroup) {
    this.packGroup = packGroup;
  }

  public String getPackArtifact() {
    return packArtifact;
  }

  public void setPackArtifact(String packArtifact) {
    this.packArtifact = packArtifact;
  }

  public String getPackVersion() {
    return packVersion;
  }

  public void setPackVersion(String packVersion) {
    this.packVersion = packVersion;
  }

  public long getPackReleaseDate() {
    return packReleaseDate;
  }

  public void setPackReleaseDate(long packReleaseDate) {
    this.packReleaseDate = packReleaseDate;
  }

  public String getRepository() {
    return repository;
  }

  public void setRepository(String repository) {
    this.repository = repository;
  }
}
