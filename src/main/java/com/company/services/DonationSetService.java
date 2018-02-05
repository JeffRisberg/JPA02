package com.company.services;

import com.company.models.OrderEntity;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 01/20/18
 */
public interface DonationSetService {

    public OrderEntity getOne(Long id);

    public List<OrderEntity> getList(int limit, int offset);
}
