package com.mymacros.services.dao.entity;

import com.mymacros.dto.entity.LoginDto;
import com.mymacros.dto.entity.ProfileDto;
import com.mymacros.dto.entity.UserAndProfileFormDto;
import com.mymacros.dto.entity.UserDto;

import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
public interface UserAndProfileServiceDao
{
     /**
      * ==================================================> <USER>
      */
     /**
      * <h1>addUserAndProfile</h1>
      * <p>Envia un usuario al modulo repostory</p>
      * @param userDto Datos Obtenidos del formulario web
      */
     void addUser(UserDto userDto);
     /**
      * <h1>addUserAndProfile</h1>
      * <p>Envia un usuario al modulo repostory</p>
      * @param userDto Datos Obtenidos del formulario web
      */
     void addUserAndProfile(UserAndProfileFormDto userDto);
     /**
      * <h1>getUser</h1>
      * <p>Busca un usuario en el respository</p>
      * @param id Indetificador del objeto a buscar
      */
     UserDto getUser(long id);
     /**
      * <h1>updateUser</h1>
      * <p>Actualiza un nuevo elemento de la base de datos</p>
      * @param formUser Datos obtenidos del formulario web
      */
     void updateUser(UserDto formUser);

     /**
      * <h1>loginUser</h1>
      * <p>Envia un objeto UserDto para identificar si el usuario se encuentra en repositorio<</p>
      *
      * @param userDto Objeto que contiene el surName y password a evaluar
      * @return Retorna true si el usuario se encuentra en el respositorio
      */
     boolean loginUser(LoginDto userDto);
     /**
      * ==================================================> <Profile>
      */
     /**
      * <h1>getProfile</h1>
      * <p>Busca un usuario en el respository</p>
      *
      * @param id Indetificador del objeto a buscar
      */
     ProfileDto getProfile(long id);



     /**
      * <h1>addProfile</h1>
      * <p>Envia un Objeto Perfil al modulo Repository</p>
      * @param profileDto Datos Obtenidos del formulario web
      */
     void addProfile(ProfileDto profileDto);

     /**
      * <h1>getAllProfile</h1>
      * <p>Se obtiene una lista de los perfiles</p>
      * @return Retorna un objeto List con el contenido de la base de datos.
      */
     List<ProfileDto> getAllProfile(long id);
     /**
      * <h1>updateProfile</h1>
      * <p>Actualiza un nuevo elemento de la base de datos</p>
      * @param formProfile Datos obtenidos del formulario web
      */
     void updateProfile(ProfileDto formProfile);

     /**
      * <h1>deleteProfile</h1>
      * <p>Elimina un objeto Profile de la base de datos</p>
      * @param id Identificador que reprecenta el objeto alamacenado.
      */
     void deleteProfile(long id);
}
