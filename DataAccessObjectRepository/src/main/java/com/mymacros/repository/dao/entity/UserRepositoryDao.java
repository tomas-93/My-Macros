package com.mymacros.repository.dao.entity;

import com.mymacros.repository.entity.UserEntity;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface UserRepositoryDao
{
     void createUser(UserEntity userDto);
     UserEntity getUser(long id);
     UserEntity getUser(String email);
     void updateUser(UserEntity userDto);
     boolean loginUser(UserEntity userDto);


}
