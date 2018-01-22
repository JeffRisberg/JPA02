package com.company.services;

import com.company.models.Order;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 01/20/18
 */
public interface DonationSetService {

    public Order getOne(Long id);

    public List<Order> getList(int limit, int offset);
}
