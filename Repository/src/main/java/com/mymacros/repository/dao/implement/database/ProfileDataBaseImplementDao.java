package com.mymacros.repository.dao.implement.database;

import com.mymacros.database.entity.ProfileEntity;
import com.mymacros.repository.dao.entity.ProfileRepositoryDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.Query;
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

    public final Logger message = LogManager.getLogger();


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
        Query query = this.getSessionFactory()
                .getCurrentSession()
                .createQuery("from ProfileEntity where userByIdUser.id = :id")
                .setParameter("id", idUser);

        List list = query.getResultList();
        return  list.isEmpty()? null: (List<ProfileEntity>) list;
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
        this.save(profileEntity.getMacrosEntity());
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
            this.update(profileEntity.getMacrosEntity());
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
        if (profileEntity != null)
        {
            this.delete(profileEntity);
        }
    }

}
