package com.company.services;

import com.company.models.DonationEntity;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/20/17
 */
public interface DonationService {

    public DonationEntity getOne(Long id);

    public List<DonationEntity> getList(int limit, int offset);
}
