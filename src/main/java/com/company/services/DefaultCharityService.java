package com.company.services;

import com.company.models.Charity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/20/17
 */
public class DefaultCharityService extends AbstractService implements CharityService {
  private static final Logger logger = LoggerFactory.getLogger(DefaultCharityService.class);

  public Charity getOne(Long id) {
    logger.debug("getOne");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      Charity result = em.find(Charity.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<Charity> getList(int limit, int offset) {
    logger.debug("getList");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<Charity> query =
          em.createQuery("SELECT i FROM Charity i", Charity.class);
      List<Charity> result = query.getResultList();

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public long getCount() throws NamingException {
    logger.debug("getCount");

    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    TypedQuery<Charity> query =
        em.createQuery("SELECT i FROM Charity i", Charity.class);
    List<Charity> result = query.getResultList();

    em.getTransaction().commit();
    em.close();

    return result.size();
  }

  public void create(Charity invocationStatus) throws NamingException {
    logger.debug("create");

    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }

  public void update(Charity invocationStatus) throws NamingException {
    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }
}
