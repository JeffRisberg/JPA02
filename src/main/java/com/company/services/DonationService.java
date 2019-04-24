package com.company.services;

import com.company.common.FilterDesc;
import com.company.models.DonationEntity;
import com.company.services.DAO.DonationDAO;

import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class DonationService extends AbstractService<DonationEntity> {
    private static DonationDAO dao = new DonationDAO();

    public DonationService() {
        this.emf = Persistence.createEntityManagerFactory("JPA02");
    }

    public DonationEntity create(DonationEntity donation) {
        final AtomicReference<DonationEntity> created = new AtomicReference<>();
        doWork(em -> created.set(dao.create(donation, em)));
        return created.get();
    }

    public DonationEntity getById(Long id) {
        final AtomicReference<DonationEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getById(id, em)));
        return td.get();
    }

    public List<DonationEntity> getAll(int limit, int offset) {
        final AtomicReference<List<DonationEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getAll(DonationEntity.class, limit, offset, em)));
        return td.get();
    }

    public List<DonationEntity> getByCriteria(List<FilterDesc> filterDescriptions, int limit, int offset) {
        final AtomicReference<List<DonationEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByCriteria(DonationEntity.class, filterDescriptions, limit, offset, em)));
        return td.get();
    }

    public boolean update(DonationEntity updatedEntity) {
        final AtomicReference<Boolean> updated = new AtomicReference<>();
        doWork(em -> updated.set(dao.update(updatedEntity, em)));
        return updated.get();
    }

    public boolean delete(Long id) {
        final AtomicReference<Boolean> deleted = new AtomicReference<>();
        doWork(em -> deleted.set(dao.delete(id, em)));
        return deleted.get();
    }
}

