package com.company.services.DAO;

import com.company.common.base.config.AppConfig;
import com.company.common.base.config.DatabaseConfig;
import com.company.models.CharityEntity;
import com.google.inject.Inject;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class CharityDAO extends BaseTemplateDAOImpl<CharityEntity> {

    public CharityDAO() {
        super(CharityEntity.class);
    }

    public CharityEntity create(CharityEntity obj, @NonNull EntityManager em) {
        return super.create(obj, em);
    }

    public CharityEntity getById(Long id, @NonNull EntityManager em) {
        return super.getById(id, em);
    }

    public Boolean delete(Long id, @NonNull EntityManager em) {
        return super.deleteById(id, em);
    }
}

