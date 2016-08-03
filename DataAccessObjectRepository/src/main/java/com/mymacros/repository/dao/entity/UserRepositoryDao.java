package com.mymacros.repository.dao.entity;

import com.mymacros.database.entity.UserEntity;
import com.mymacros.dto.entity.LoginDto;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface UserRepositoryDao
{
     void createUser(UserEntity userDto);
     UserEntity getUser(long id);
     void updateUser(UserEntity userDto);
     UserEntity loginUser(LoginDto userDto);


}
