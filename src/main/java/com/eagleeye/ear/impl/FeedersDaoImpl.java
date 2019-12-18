package com.eagleeye.ear.impl;

import com.eagleeye.ear.dao.FeedersDao;
import com.eagleeye.ear.models.Feeder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

import java.util.List;
import java.util.UUID;

public class FeedersDaoImpl implements FeedersDao {

  private SessionFactory sessionFactory;

  @Override
  public Feeder getFeederById(UUID id) {

    Session session = openSession();

    Feeder feeder = (Feeder) session.get(Feeder.class, id);

    closeSession(session);

    return feeder;
  }

  @Override public List<Feeder> getFeeders() {

    Session session = openSession();

    Query query = session.createNativeQuery("select * from feeders;", Feeder.class);
    List<Feeder> feeders = query.getResultList();

    closeSession(session);

    return feeders;
  }

  public Session openSession() {

    sessionFactory = new Configuration().configure().buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();

    return session;
  }

  public void closeSession(Session session) {

    session.getSessionFactory().close();
  }
}
