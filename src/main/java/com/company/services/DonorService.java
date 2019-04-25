package com.company.services;

import com.company.common.FilterDescription;
import com.company.models.DonorEntity;
import com.company.services.DAO.DonorDAO;

import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DonorService extends AbstractService<DonorEntity> {
    private static DonorDAO dao = new DonorDAO();

    public DonorService() {
        this.emf = Persistence.createEntityManagerFactory("JPA02");
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
        doWork(em -> updated.set(dao.update(updatedEntity, em)));
        return updated.get();
    }

    public boolean delete(Long id) {
        final AtomicReference<Boolean> deleted = new AtomicReference<>();
        doWork(em -> deleted.set(dao.delete(id, em)));
        return deleted.get();
    }

    public DonorEntity getByName(String name) {
        final AtomicReference<DonorEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByName(name, em)));
        return td.get();
    }
}

