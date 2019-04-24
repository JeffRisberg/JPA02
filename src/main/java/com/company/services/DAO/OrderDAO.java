package com.company.services.DAO;

import com.company.models.OrderEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class OrderDAO extends BaseDAOImpl {

    @Override
    public <T> T create(T obj, Class<T> type, EntityManager em) {
        return super.create(obj, type, em);
    }

    public OrderEntity create(OrderEntity obj, @NonNull EntityManager em) {
        return super.create(obj, OrderEntity.class, em);
    }

    public OrderEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(OrderEntity.class, id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(OrderEntity.class, id, em);
    }
}

