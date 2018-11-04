package com.company.services;

import com.company.models.DonationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 01/10/18
 */
public class DefaultDonationService extends AbstractService implements DonationService {
  private static final Logger logger = LoggerFactory.getLogger(DefaultDonationService.class);

  public DonationEntity getOne(Long id) {
    logger.debug("getOne");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      DonationEntity result = em.find(DonationEntity.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<DonationEntity> getList(int limit, int offset) {
    logger.debug("getList");

    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<DonationEntity> query =
          em.createQuery("SELECT i FROM DonationEntity i", DonationEntity.class);
      List<DonationEntity> result = query.getResultList();

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

    TypedQuery<DonationEntity> query =
        em.createQuery("SELECT i FROM DonationEntity i", DonationEntity.class);
    List<DonationEntity> result = query.getResultList();

    em.getTransaction().commit();
    em.close();

    return result.size();
  }

  public void create(DonationEntity invocationStatus) throws NamingException {
    logger.debug("create");

    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }

  public void update(DonationEntity invocationStatus) throws NamingException {
    EntityManager em = getEntityManager();

    em.getTransaction().begin();

    em.persist(invocationStatus);

    em.getTransaction().commit();
    em.close();
  }
}
