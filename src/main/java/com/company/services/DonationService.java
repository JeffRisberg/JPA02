package com.company.services;

import com.company.models.Donation;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/20/17
 */
public interface DonationService {

    public Donation getOne(Long id);

    public List<Donation> getList(int limit, int offset);
}
