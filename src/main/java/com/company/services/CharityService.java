package com.company.services;

import com.company.common.FilterDescription;
import com.company.models.CharityEntity;
import com.company.services.DAO.CharityDAO;

import javax.persistence.Persistence;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CharityService extends AbstractService<CharityEntity> {
    private static CharityDAO dao = new CharityDAO();

    public CharityService() {
        this.emf = Persistence.createEntityManagerFactory("JPA02");
    }

    public CharityEntity create(CharityEntity charity) {
        final AtomicReference<CharityEntity> created = new AtomicReference<>();
        doWork(em -> created.set(dao.create(charity, em)));
        return created.get();
    }

    public CharityEntity getById(Long id) {
        final AtomicReference<CharityEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getById(id, em)));
        return td.get();
    }

    public List<CharityEntity> getAll(int limit, int offset) {
        final AtomicReference<List<CharityEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.listAll(CharityEntity.class, limit, offset, em)));
        return td.get();
    }

    public List<CharityEntity> getByCriteria(List<FilterDescription> filterDescriptions, int limit, int offset) {
        final AtomicReference<List<CharityEntity>> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByCriteria(filterDescriptions, limit, offset, em)));
        return td.get();
    }

    public boolean update(CharityEntity updatedEntity) {
        final AtomicReference<Boolean> updated = new AtomicReference<>();
        doWork(em -> updated.set(dao.update(updatedEntity, em)));
        return updated.get();
    }

    public boolean delete(Long id) {
        final AtomicReference<Boolean> deleted = new AtomicReference<>();
        doWork(em -> deleted.set(dao.delete(id, em)));
        return deleted.get();
    }

    public CharityEntity getByName(String name) {
        final AtomicReference<CharityEntity> td = new AtomicReference<>();
        doWork(em -> td.set(dao.getByName(name, em)));
        return td.get();
    }
}

