package com.mymacros.services;

import com.mymacros.dto.entity.*;
import com.mymacros.repository.dao.entity.*;
import com.mymacros.services.dao.entity.UserAndProfileServiceDao;
import com.mymacros.services.util.Convert;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

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
    @Inject
    private MacronutrientsRepositoryDao macronutrientsRepositoryDao;
    /**
     * <h1>getUser</h1>
     * <p>Busca un usuario en el respository</p>
     *
     * @param id Indetificador del objeto a buscar
     */
    @Override
    public UserDto getUser(long id)
    {
        return Convert.userDto(this.userRepositoryDao.getUser(id));
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
        return Convert.profileDto(this.profileRepositoryDao.getProfile(id));
    }

    /**
     * Busca un objeto en el repositorio por el parametro email
     *
     * @param loginDto Objeto que contiene password y contraseña
     * @return retorna un userDto tras la busqueda
     */
    @Override
    public UserDto login(LoginDto loginDto)
    {
        UserEntity userEntity = this.userRepositoryDao.loginUser(loginDto);
        if (userEntity.getEmail() == null)
            return null;
        return Convert.userDto(userEntity);
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
        this.userRepositoryDao.createUser(Convert.userEntity(userDto));
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
        this.profileRepositoryDao.createProfile(Convert.profileEntity(profileDto));
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
        return this.profileRepositoryDao.getAllProfiles(idUser)
                .stream()
                .map(Convert::profileDto)
                .collect(Collectors.toList());

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
        this.userRepositoryDao.updateUser(Convert.userEntity(userDto));
    }
    /**
     * <h1>updateProfile</h1>
     * <p>Actualiza un nuevo elemento de la base de datos</p>
     *
     * @param profileDto Datos obtenidos del formulario web
     */
    @Override
    public void updateProfile(ProfileDto profileDto)
    {
        this.profileRepositoryDao.updateProfile(Convert.profileEntity(profileDto));
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
        ProfileEntity profileEntity = this.profileRepositoryDao.getProfile(id);
        this.profileRepositoryDao.deleteProfile(id);
        this.macronutrientsRepositoryDao.deleteMacronutrients(profileEntity.getMacrosEntity().getId());
    }
}
