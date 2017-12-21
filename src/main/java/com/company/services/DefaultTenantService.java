package com.company.services;

import com.company.models.Tenant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Jeff Risberg
 * @since 12/15/17
 */
public class DefaultTenantService extends AbstractService implements TenantService {
  private static final Logger logger = LoggerFactory.getLogger(DefaultTenantService.class);

  public Tenant getOne(Long id) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      Tenant result = em.find(Tenant.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<Tenant> getList(int limit, int offset) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<Tenant> query =
          em.createQuery("SELECT m FROM Message m", Tenant.class);
      List<Tenant> result = query.getResultList();

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }
}
