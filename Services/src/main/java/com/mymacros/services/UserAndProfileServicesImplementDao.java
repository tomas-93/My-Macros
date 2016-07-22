package com.mymacros.services;

import com.mymacros.dto.entity.ProfileDto;
import com.mymacros.dto.entity.UserAndProfileFormDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.repository.dao.entity.ProfileRepositoryDao;
import com.mymacros.repository.dao.entity.UserRepositoryDao;
import com.mymacros.services.dao.entity.UserAndProfileServiceDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
@Service
public class UserAndProfileServicesImplementDao implements UserAndProfileServiceDao
{

     @Inject
     private UserRepositoryDao userRepositoryDao;
     @Inject
     private ProfileRepositoryDao profileRepositoryDao;
     /**
      * <h1>getUser</h1>
      * <p>Busca un usuario en el respository</p>
      *
      * @param id Indetificador del objeto a buscar
      */
     @Override
     public UserDto getUser(long id)
     {
          return this.userRepositoryDao.getUser(id);
     }

     /**
      * <h1>getProfile</h1>
      * <p>Busca un usuario en el respository</p>
      *
      * @param id Indetificador del objeto a buscar
      */
     @Override
     public ProfileDto getProfile(long id)
     {
          return this.profileRepositoryDao.getProfile(id);
     }

     /**
      * <h1>addUserAndProfile</h1>
      * <p>Envia un usuario al modulo repostory</p>
      *
      * @param userDto Datos Obtenidos del formulario web
      */
     @Override
     public void addUser(UserDto userDto)
     {
          this.userRepositoryDao.createUser(userDto);
     }

     /**
      * <h1>addProfile</h1>
      * <p>Envia un Objeto Perfil al modulo Repository</p>
      *
      * @param profileDto Datos Obtenidos del formulario web
      */
     @Override
     public void addProfile(ProfileDto profileDto)
     {
          if (profileDto.getId() == 0)
               profileDto.setId(this.profileRepositoryDao.getIncrementID());
          this.profileRepositoryDao.createProfile(profileDto);
     }

     /**
      * <h1>getAllProfile</h1>
      * <p>Se obtiene una lista de los perfiles</p>
      *
      * @return Retorna un objeto List con el contenido de la base de datos.
      */
     @Override
     public List<ProfileDto> getAllProfile(long idUser)
     {
          return this.profileRepositoryDao.getAllProfiles(idUser);
     }

     /**
      * <h1>updateUser</h1>
      * <p>Actualiza un nuevo elemento de la base de datos</p>
      *
      * @param userDto Datos obtenidos del formulario web
      */
     @Override
     public void updateUser(UserDto userDto)
     {
          this.userRepositoryDao.updateUser(userDto);
     }

     /**
      * <h1>loginUser</h1>
      * <p>Envia un objeto UserDto para identificar si el usuario se encuentra en repositorio<</p>
      *
      * @param userDto
      * @return
      */
     @Override
     public boolean loginUser(UserDto userDto)
     {
          return this.userRepositoryDao.loginUser(userDto);
     }

     /**
      * <h1>updateProfile</h1>
      * <p>Actualiza un nuevo elemento de la base de datos</p>
      *
      * @param formProfile Datos obtenidos del formulario web
      */
     @Override
     public void updateProfile(ProfileDto formProfile)
     {
          this.profileRepositoryDao.updateProfile(formProfile);
     }

     /**
      * <h1>deleteProfile</h1>
      * <p>Elimina un objeto Profile de la base de datos</p>
      *
      * @param id Identificador que reprecenta el objeto alamacenado.
      */
     @Override
     public void deleteProfile(long id)
     {
          this.profileRepositoryDao.deleteProfile(id);
     }

     /**
      * <h1>addUserAndProfile</h1>
      * <p>Este metodo es usado cuando se recibe los datos a traves del formulario </p>
      * @param userAndProfileDto Reprecenta el objeto recibido del formulario
      */
     public void addUserAndProfile(UserAndProfileFormDto userAndProfileDto)
     {
          long idUser = this.userRepositoryDao.getIncrementID();
          long idProfile = this.profileRepositoryDao.getIncrementID();
          this.addUser(new UserDto(idUser,
                                      userAndProfileDto.getName(),
                                      userAndProfileDto.getSurname(),
                                      userAndProfileDto.getHeigth(),
                                      userAndProfileDto.getWidth(),
                                      userAndProfileDto.getUserName(),
                                      userAndProfileDto.getPassword(),
                                      userAndProfileDto.getTimeDate()));
          this.addProfile(new ProfileDto(idProfile,
                                           idUser,
                                           userAndProfileDto.getCarbs(),
                                           userAndProfileDto.getFat(),
                                           userAndProfileDto.getProtein(),
                                           userAndProfileDto.getFiber(),
                                           userAndProfileDto.getTotalCalories()));
     }
}
