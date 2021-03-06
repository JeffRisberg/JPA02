package com.company.services.DAO;

import com.company.models.DonorEntity;
import lombok.NonNull;

import javax.persistence.EntityManager;

public class DonorDAO extends BaseTemplateDAOImpl<DonorEntity> {

  public DonorDAO() {
    super(DonorEntity.class);
  }

  public DonorEntity create(DonorEntity obj, @NonNull EntityManager em) {
    return super.create(obj, em);
  }

  public DonorEntity getById(Long id, @NonNull EntityManager em) {
    return super.getById(id, em);
  }

  public Boolean delete(Long id, @NonNull EntityManager em) {
    return super.deleteById(id, em);
  }
}

