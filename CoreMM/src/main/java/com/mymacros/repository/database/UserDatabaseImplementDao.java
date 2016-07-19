package com.mymacros.repository.database;

import com.mymacros.dao.entity.UserDao;
import com.mymacros.dto.entity.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class UserDatabaseImplementDao implements UserDao
{
     private final Map<Long, UserDto> userDtoMapDatabase = new Hashtable<Long, UserDto>();
     private volatile long idUser = 1L;

     public synchronized void createUser(UserDto userDto)
     {
          if(!userDtoMapDatabase.isEmpty())
               this.idUser ++;
          userDto.setId(this.idUser);
          this.userDtoMapDatabase.put(userDto.getId(), userDto);
     }
     public synchronized UserDto getUser(long id)
     {
          if (id == 0)
               return null;
          if (id > userDtoMapDatabase.size())
               return null;

          return this.userDtoMapDatabase.get(id);
     }
     public synchronized void updateUser(UserDto userDto)
     {
          if (userDto == null);
          if (this.userDtoMapDatabase.containsKey(userDto.getId()));
          else
               this.userDtoMapDatabase.replace(userDto.getId(), userDto);

     }
}
