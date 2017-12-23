package com.company.services;

import com.company.models.Tenant;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 12/20/17
 */
public interface TenantService {

    public Tenant getOne(Long id);

    public List<Tenant> getList(int limit, int offset);

    public void create(String name);
}
