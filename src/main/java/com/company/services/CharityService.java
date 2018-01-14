package com.company.services;

import com.company.models.Charity;
import com.company.models.Donation;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/30/17
 */
public interface CharityService {

    public Charity getOne(Long id);

    public List<Charity> getList(int limit, int offset);
}
