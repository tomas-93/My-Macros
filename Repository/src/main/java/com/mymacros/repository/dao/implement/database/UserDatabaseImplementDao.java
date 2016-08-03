package com.mymacros.repository.dao.implement.database;


import com.mymacros.database.entity.UserEntity;
import com.mymacros.dto.entity.LoginDto;
import com.mymacros.repository.dao.entity.UserRepositoryDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;
import java.util.List;


/**
 * @author Tomas Yussef Galicia Guzman
 */
@Repository
public class UserDatabaseImplementDao extends HibernateTemplate implements UserRepositoryDao
{
    private final Logger message = LogManager.getLogger();

    @Inject
    public UserDatabaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
    /**
     * <h1>Crear Usuario</h1>
     * <p>Metodo para crear usuarios</p>
     *
     * @param userEntity entidad que sera guardado en la base de datos
     */
    @Override
    public void createUser(UserEntity userEntity)
    {
        this.save(userEntity);
    }

    /**
     * <h1>Get User</h1>
     * <p>Obtiene un usuario especifico</p>
     *
     * @param id identificador del usuario que se quiere obtiner
     * @return Retorna un objecto UserDto obtenida de la base de datos
     */
    @Override
    public UserEntity getUser(long id)
    {
        return this.load(UserEntity.class, id);
    }

    /**
     * <h1>Update User</h1>
     * <p>Actualiza una entidad</p>
     *
     * @param userEntity Entidad que sera actualizado en la base de datos.
     */
    @Override
    public void updateUser(UserEntity userEntity)
    {
        this.update(userEntity);
    }

    /**
     * <h1>loginUser</h1>
     * <p>Busca en la base de datos si el usuario se encuentra registrado.</p>
     *
     * @param userDto Reprecenta el obejeto que tiene los elemetos necesarios para iniciar secion
     * @return Retorna verdadero si el usuario se encuentra registrado y falso si no.
     */

    @Override
    public UserEntity loginUser(LoginDto userDto)
    {
        List list = this.find("from UserEntity WHERE email = '"+userDto.getEmail()+"'");
        return  list.isEmpty()  ?  null : (UserEntity) list.get(0);
    }

}
