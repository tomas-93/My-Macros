package com.mymacros.repository.database;

import com.mymacros.repository.dao.entity.UserRepositoryDao;
import com.mymacros.dto.entity.UserDto;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class UserDatabaseImplementDao implements UserRepositoryDao {

     private final Map<Long, UserDto> userDtoMapDatabase = new Hashtable<Long, UserDto>();
     private volatile long idUser = 1L;

     /**
      * <h1>Crear Usuario</h1>
      * <p>Metodo para crear usuarios</p>
      *
      * @param userDto entidad que sera guardado en la base de datos
      */
     public void createUser(UserDto userDto)
     {
          this.userDtoMapDatabase.put(userDto.getId(), userDto);
     }

     /**
      * <h1>Get User</h1>
      * <p>Obtiene un usuario especifico</p>
      *
      * @param id identificador del usuario que se quiere obtiner
      * @return Retorna un objecto UserDto obtenida de la base de datos
      */
     public UserDto getUser(long id)
     {
          return this.userDtoMapDatabase.get(id);
     }

     /**
      * <h1>Update User</h1>
      * <p>Actualiza una entidad</p>
      *
      * @param userDto Entidad que sera actualizado en la base de datos.
      */
     public void updateUser(UserDto userDto) {
          this.userDtoMapDatabase.replace(userDto.getId(), userDto);
     }


     @Override
     public synchronized long getIncrementID() {
          return this.idUser++;
     }
}
