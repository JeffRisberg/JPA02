package com.company.services;

import com.company.common.FilterDescription;
import com.company.models.OrderEntity;
import com.company.services.DAO.OrderDAO;
import com.google.inject.Inject;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class OrderService extends AbstractService<OrderEntity> {
    private final OrderDAO dao;

    @Inject
    public OrderService(final MyEntityManagerFactory myEntityManagerFactory,
                        final OrderDAO orderDAO) {
        this.myEntityManagerFactory = myEntityManagerFactory;
        this.dao = orderDAO;
    }

    public OrderEntity getById(Long id) {
        final AtomicReference<OrderEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getById(id, em)));
        return td.get();
    }

    public List<OrderEntity> getAll(int limit, int offset) {
        final AtomicReference<List<OrderEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.listAll(OrderEntity.class, limit, offset, em)));
        return td.get();
    }

    public List<OrderEntity> getByCriteria(List<FilterDescription> filterDescriptions, int limit, int offset) {
        final AtomicReference<List<OrderEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByCriteria(filterDescriptions, limit, offset, em)));
        return td.get();
    }

    public OrderEntity create(OrderEntity order) {
        final AtomicReference<OrderEntity> created = new AtomicReference<>();
        doWork(em -> created.set(dao.create(order, em)));
        return created.get();
    }

    public boolean update(OrderEntity updatedEntity) {
        final AtomicReference<Boolean> updated = new AtomicReference<>();
        doWork(em -> updated.set(dao.update(updatedEntity, em)));
        return updated.get();
    }

    public boolean delete(Long id) {
        final AtomicReference<Boolean> deleted = new AtomicReference<>();
        doWork(em -> deleted.set(dao.delete(id, em)));
        return deleted.get();
    }

    public OrderEntity getByName(String name) {
        final AtomicReference<OrderEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByName(name, em)));
        return td.get();
    }
}

