package com.company.services.DAO;

import com.company.models.DonationEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class DonationDAO extends BaseDAOImpl {

    @Override
    public <T> T create(T obj, Class<T> type, EntityManager em) {
        return super.create(obj, type, em);
    }

    public DonationEntity create(DonationEntity obj, @NonNull EntityManager em) {
        return super.create(obj, DonationEntity.class, em);
    }

    public DonationEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(DonationEntity.class, id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(DonationEntity.class, id, em);
    }
}

