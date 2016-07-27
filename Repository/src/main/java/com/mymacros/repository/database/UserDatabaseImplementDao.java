package com.mymacros.repository.database;

import com.mymacros.dto.entity.LoginDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.repository.dao.entity.UserRepositoryDao;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class UserDatabaseImplementDao implements UserRepositoryDao
{
     private final Map<Long, UserDto> userDtoMapDatabase = new Hashtable<>();
     private volatile long idUser = 1L;

     /**
      * <h1>Crear Usuario</h1>
      * <p>Metodo para crear usuarios</p>
      *
      * @param userDto entidad que sera guardado en la base de datos
      */
     @Override
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
     @Override
     public UserDto getUser(long id)
     {
          return this.userDtoMapDatabase.get(id);
     }

     /**
      * Busca un objeto en el repositorio por el parametro email
      *
      * @param email de l usuario
      * @return retorna un userDto tras la busqueda
      */
     @Override
     public UserDto getUser(String email)
     {
          return this.userDtoMapDatabase.keySet()
                  .stream()
                  .map(this.userDtoMapDatabase::get)
                  .filter(userDto -> userDto.equals(email))
                  .collect(Collectors.toList())
                  .get(0);
     }

     /**
      * <h1>Update User</h1>
      * <p>Actualiza una entidad</p>
      *
      * @param userDto Entidad que sera actualizado en la base de datos.
      */
     @Override
     public void updateUser(UserDto userDto) {
          this.userDtoMapDatabase.replace(userDto.getId(), userDto);
     }

     /**
      * <h1>loginUser</h1>
      * <p>Busca en la base de datos si el usuario se encuentra registrado.</p>
      * @param userDto Reprecenta el obejeto que tiene los elemetos necesarios para iniciar secion
      * @return Retorna verdadero si el usuario se encuentra registrado y falso si no.
      */

     @Override
     public boolean loginUser(LoginDto userDto)
     {
          boolean flag = !this.userDtoMapDatabase.keySet()
                 .stream()
                 .map(this.userDtoMapDatabase::get)
                 .filter(userDto1 -> userDto1.getEmail().equals(userDto.getEmail()) &&
                         userDto1.getPassword().equals(userDto.getPassword()))
                 .collect(Collectors.toList())
                 .isEmpty();
          return flag;
     }


     @Override
     public synchronized long getIncrementID() {
          return this.idUser++;
     }
}
