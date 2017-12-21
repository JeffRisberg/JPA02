package com.company.services;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Jeff Risberg
 * @since 11/11/17
 */
public class AbstractService {

  protected EntityManager getEntityManager() throws NamingException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("docker02");
    return emf.createEntityManager();
  }
}