package com.company.services;

import com.company.common.FilterDescription;
import com.company.models.DonorEntity;
import com.company.services.DAO.DonorDAO;
import com.google.inject.Inject;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DonorService extends AbstractService<DonorEntity> {
  private final DonorDAO dao;

  @Inject
  public DonorService(final MyEntityManagerFactory myEntityManagerFactory,
                      final DonorDAO donorDAO) {
    this.myEntityManagerFactory = myEntityManagerFactory;
    this.dao = donorDAO;
  }

  public DonorEntity getById(Long id) {
    final AtomicReference<DonorEntity> td = new AtomicReference<>();
    doWork(em -> td.set(dao.getById(id, em)));
    return td.get();
  }

  public List<DonorEntity> getAll(int limit, int offset) {
    final AtomicReference<List<DonorEntity>> td = new AtomicReference<>();
    doWork(em -> td.set(dao.listAll(DonorEntity.class, limit, offset, em)));
    return td.get();
  }

  public List<DonorEntity> getByCriteria(List<FilterDescription> filterDescriptions, int limit, int offset) {
    final AtomicReference<List<DonorEntity>> td = new AtomicReference<>();
    doWork(em -> td.set(dao.getByCriteria(filterDescriptions, limit, offset, em)));
    return td.get();
  }

  public DonorEntity create(DonorEntity donor) {
    final AtomicReference<DonorEntity> created = new AtomicReference<>();
    doWork(em -> created.set(dao.create(donor, em)));
    return created.get();
  }

  public boolean update(DonorEntity updatedEntity) {
    final AtomicReference<Boolean> updated = new AtomicReference<>();
    boolean success = doWork(em -> updated.set(dao.update(updatedEntity, em)));
    return success && updated.get();
  }

  public boolean delete(Long id) {
    final AtomicReference<Boolean> deleted = new AtomicReference<>();
    boolean success = doWork(em -> deleted.set(dao.delete(id, em)));
    return success && deleted.get();
  }

  public DonorEntity getByName(String name) {
    final AtomicReference<DonorEntity> td = new AtomicReference<>();
    doWork(em -> td.set(dao.getByName(name, em)));
    return td.get();
  }
}

