package com.company.services;

import com.company.models.UserEntity;
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

  public UserEntity getOne(Long id) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      UserEntity result = em.find(UserEntity.class, id);

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }

  public List<UserEntity> getList(int limit, int offset) {
    try {
      EntityManager em = getEntityManager();

      em.getTransaction().begin();

      TypedQuery<UserEntity> query =
          em.createQuery("SELECT u FROM UserEntity u", UserEntity.class);
      List<UserEntity> result = query.getResultList();

      em.getTransaction().commit();
      em.close();

      return result;
    } catch (NamingException e) {
      return null;
    }
  }
}
