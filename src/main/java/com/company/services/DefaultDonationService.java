package com.company.services;

import com.company.models.Donation;
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
public class DefaultDonationService extends AbstractService implements DonationService {
  private static final Logger logger = LoggerFactory.getLogger(DefaultDonationService.class);

  public Donation getOne(Long id) {
    logger.debug("getOne");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      Donation result = em.find(Donation.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<Donation> getList(int limit, int offset) {
    logger.debug("getList");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<Donation> query =
          em.createQuery("SELECT i FROM Donation i", Donation.class);
      List<Donation> result = query.getResultList();

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

    TypedQuery<Donation> query =
        em.createQuery("SELECT i FROM Donation i", Donation.class);
    List<Donation> result = query.getResultList();

    em.getTransaction().commit();
    em.close();

    return result.size();
  }

  public void create(Donation invocationStatus) throws NamingException {
    logger.debug("create");

    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }

  public void update(Donation invocationStatus) throws NamingException {
    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }
}
