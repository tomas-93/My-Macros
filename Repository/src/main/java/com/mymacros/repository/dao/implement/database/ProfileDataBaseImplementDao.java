package com.mymacros.repository.dao.implement.database;

import com.mymacros.database.entity.ProfileEntity;
import com.mymacros.repository.dao.entity.ProfileRepositoryDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import java.util.List;

/**
 * @author Tomas Yussef Galicia Guzman
 */
@Repository
public class ProfileDataBaseImplementDao extends HibernateTemplate implements ProfileRepositoryDao
{
    @Inject
    public ProfileDataBaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
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
                this.find("from ProfileEntity inner join UserEntity" +
                        " where ProfileEntity.userByIdUser=:idUser", idUser);
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
        return this.load(ProfileEntity.class, id);
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
        this.save(profileEntity);
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
        if (this.load(ProfileEntity.class, profileEntity.getId()) != null)
        {
            this.update(profileEntity);
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
        ProfileEntity profileEntity = this.load(ProfileEntity.class, id);
        if ( profileEntity != null)
        {
            this.delete(profileEntity);
        }
    }

}
