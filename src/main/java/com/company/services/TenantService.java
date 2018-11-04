package com.company.services;

import com.company.models.TenantEntity;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 12/20/17
 */
public interface TenantService {

    public TenantEntity getOne(Long id);

    public List<TenantEntity> getList(int limit, int offset);

    public TenantEntity create(String name);
}
