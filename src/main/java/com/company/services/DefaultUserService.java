package com.company.services;

import com.company.models.User;
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
public class DefaultUserService extends AbstractService implements UserService {
  private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

  public User getOne(Long id) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      User result = em.find(User.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<User> getList(int limit, int offset) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<User> query =
          em.createQuery("SELECT u FROM User u", User.class);
      List<User> result = query.getResultList();

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }
}
