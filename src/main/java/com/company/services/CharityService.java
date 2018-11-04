package com.company.services;

import com.company.models.CharityEntity;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public interface CharityService {

    public CharityEntity getOne(Long id);

    public List<CharityEntity> getList(int limit, int offset);
}
