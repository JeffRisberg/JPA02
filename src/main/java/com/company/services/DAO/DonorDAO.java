package com.company.services.DAO;

import com.company.models.DonorEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DonorDAO extends BaseDAOImpl {

    @Override
    public <T> T create(T obj, Class<T> type, EntityManager em) {
        return super.create(obj, type, em);
    }

    public DonorEntity create(DonorEntity obj, @NonNull EntityManager em) {
        return super.create(obj, DonorEntity.class, em);
    }

    public DonorEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(DonorEntity.class, id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(DonorEntity.class, id, em);
    }

    public List<DonorEntity> getByName(String name, @NonNull EntityManager em) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<DonorEntity> criteria = cb.createQuery(DonorEntity.class);
            Root root = criteria.from(DonorEntity.class);
            criteria.where(cb.equal(root.get("name"), name));
            List<DonorEntity> results = em.createQuery(criteria).getResultList();
            return results;
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}

