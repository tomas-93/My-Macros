package com.mymacros.repository.dao.database;


import com.mymacros.dto.entity.LoginDto;
import com.mymacros.repository.dao.entity.UserRepositoryDao;
import com.mymacros.repository.dao.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;


/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class UserDatabaseImplementDao implements UserRepositoryDao
{
    private final Session session;

    @Inject
    public UserDatabaseImplementDao(Session session)
    {
        this.session = session;
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
        this.session.save(userEntity);
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
        return this.session.load(UserEntity.class, id);
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
        this.session.update(userEntity);
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
        return (UserEntity)
                this.session.createQuery("from UserEntity WHERE " +
                        "UserEntity.email = :email")
                        .setParameter("email",userDto.getEmail());
    }

}
