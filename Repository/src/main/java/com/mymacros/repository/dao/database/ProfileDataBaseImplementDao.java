package com.mymacros.repository.dao.database;

import com.mymacros.repository.dao.entity.ProfileEntity;
import com.mymacros.repository.dao.entity.ProfileRepositoryDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import java.util.List;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class ProfileDataBaseImplementDao implements ProfileRepositoryDao
{
    @Inject
    private Session session;
    /**
     * <h1>getAllProfiles</h1>
     * <p>Se obtiene una lista de perfile de toda la base de datos</p>
     *
     * @return idUser Identificador de la relacion de usuarios con macros
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<ProfileEntity> getAllProfiles(long idUser)
    {
        return (List<ProfileEntity>)
                this.session.createQuery("from ProfileEntity inner join UserEntity" +
                        " where ProfileEntity.userByIdUser=:idUser")
                        .setParameter("idUser", idUser)
                        .list();
    }

    /**
     * <h1>getProfile</h1>
     * <p>Se obtiene un elemeto especifico de la base de datos</p>
     *
     * @param id Identificador que especifica el objeto a buscar.
     * @return Retorna el objeto con los valores obtenidos de la base de datos.
     */
    @Override
    public ProfileEntity getProfile(long id)
    {
        return this.session.load(ProfileEntity.class, id);
    }

    /**
     * <h1>createProfile</h1>
     * <p>Añade un nuevo elemento a la base de datos</p>
     *
     * @param profileEntity Objeto que encapsula la informacion a guardar
     */
    @Override
    public void createProfile(ProfileEntity profileEntity)
    {
        this.session.save(profileEntity);
    }

    /**
     * <h1>updateProfile</h1>
     * <p>Actualiza un elemeto de la base de datos</p>
     *
     * @param profileEntity Objeto que tiene los elemetos actualizados de la base de datos.
     */
    @Override
    public void updateProfile(ProfileEntity profileEntity)
    {
        if (this.session.load(ProfileEntity.class, profileEntity.getId()) != null)
        {
            this.session.update(profileEntity);
        }
    }

    /**
     * <h1>deleteProfile</h1>
     * <p>Elimina un elemeto de la base de datos</p>
     *
     * @param id Identificador que representa el elemto a eliminar.
     */
    @Override
    public void deleteProfile(long id)
    {
        if (this.session.load(ProfileEntity.class, id) != null)
        {
            this.session.remove(id);
        }
    }

}
