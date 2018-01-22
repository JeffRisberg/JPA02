package com.company.services;

import com.company.models.Donation;
import com.company.models.DonationSet;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 01/20/18
 */
public interface DonationSetService {

    public DonationSet getOne(Long id);

    public List<DonationSet> getList(int limit, int offset);
}
