package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.LoginDto;
import com.mymacros.dto.entity.UserDto;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface UserRepositoryDao extends IDBase
{
     void createUser(UserDto userDto);
     UserDto getUser(long id);
     UserDto getUser(String email);
     void updateUser(UserDto userDto);
     boolean loginUser(LoginDto userDto);


}
