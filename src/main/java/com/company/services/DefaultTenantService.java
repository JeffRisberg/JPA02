package com.company.services;

import com.company.models.TenantEntity;
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

    public TenantEntity getOne(Long id) {
        try {
            EntityManager em = getEntityManager();

            em.getTransaction().begin();

            TenantEntity result = em.find(TenantEntity.class, id);

            em.getTransaction().commit();
            em.close();

            return result;
        } catch (NamingException e) {
            return null;
        }
    }

    public List<TenantEntity> getList(int limit, int offset) {
        try {
            EntityManager em = getEntityManager();

            em.getTransaction().begin();

            TypedQuery<TenantEntity> query =
                    em.createQuery("SELECT t FROM TenantEntity t", TenantEntity.class);
            List<TenantEntity> result = query.getResultList();

            em.getTransaction().commit();
            em.close();

            return result;
        } catch (NamingException e) {
            return null;
        }
    }

    @Override
    public TenantEntity create(String name) {
        try {
            EntityManager em = getEntityManager();

            em.getTransaction().begin();

            TenantEntity tenant = new TenantEntity();
            tenant.setName(name);

            em.persist(tenant);

            em.getTransaction().commit();
            em.close();

            System.out.println(tenant);
        } catch (NamingException e) {
        }
        return null;
    }
}
