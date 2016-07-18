package com.mymacros.repository.database;

import com.mymacros.dao.UserDao;
import com.mymacros.dto.entity.UserDto;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
public class UserDatabaseImplementDao implements UserDao
{
     private final Map<Long, UserDto> userDtoMapDatabase = new Hashtable<Long, UserDto>();
     private volatile long idUser = 1L;
     private UserDto userDto;


     public void createUser(UserDto userDto)
     {

     }

     public UserDto getUser(long id)
     {
          return null;
     }

     public void updateUser(UserDto userDto)
     {

     }
}
