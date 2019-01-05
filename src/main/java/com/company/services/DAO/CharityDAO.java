package com.company.services.DAO;

import com.company.models.CharityEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CharityDAO extends BaseDAOImpl {

    @Override
    public <T> T create(T obj, Class<T> type, EntityManager em) {
        return super.create(obj, type, em);
    }

    public CharityEntity create(CharityEntity obj, @NonNull EntityManager em) {
        return super.create(obj, CharityEntity.class, em);
    }

    public CharityEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(CharityEntity.class, id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(CharityEntity.class, id, em);
    }

    public List<CharityEntity> getByName(String name, @NonNull EntityManager em) {
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<CharityEntity> criteria = cb.createQuery(CharityEntity.class);
            Root root = criteria.from(CharityEntity.class);
            criteria.where(cb.equal(root.get("name"), name));
            List<CharityEntity> results = em.createQuery(criteria).getResultList();
            return results;
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}

