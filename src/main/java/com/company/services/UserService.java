package com.company.services;

import com.company.models.UserEntity;

import java.util.List;

/**
 * @author Jeff Risberg
 * @since 11/20/17
 */
public interface UserService {

    public UserEntity getOne(Long Id);

    public List<UserEntity> getList(int limit, int offset);

}
