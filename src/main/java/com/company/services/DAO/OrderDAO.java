package com.company.services.DAO;

import com.company.models.OrderEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class OrderDAO extends BaseTemplateDAOImpl<OrderEntity> {

    public OrderDAO() {
        super(OrderEntity.class);
    }

    public OrderEntity create(OrderEntity obj, @NonNull EntityManager em) {
        return super.create(obj, em);
    }

    public OrderEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(id, em);
    }
}

