package com.mymacros.repository.dao.implement.database;

import com.mymacros.database.entity.FoodEntity;
import com.mymacros.repository.dao.entity.FoodRepositoryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Tomas Yussef Galicia Guzman
 */
@Repository
public class FoodDataBaseImplementDao extends HibernateTemplate implements FoodRepositoryDao
{
    @Inject
    public FoodDataBaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    /**
     * <h1>getAllFood</h1>
     * <p>Obtiene una lista de food de la base de datos</p>
     *
     * @return Retorna una un objeto List que tiene una serie de objetos de la base de datos
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<FoodEntity> getAllFood(long idUser)
    {
        return (List<FoodEntity>)
                this.find("from FoodEntity inner join UserEntity where  FoodEntity.userByIdUser=:idUser", idUser);
    }

    /**
     * <h1>getFood</h1>
     * <p>Obtiene un dato de la base de datos</p>
     *
     * @param id especifica el identificador de un objeto guardado en la base de datos
     * @return retorna el objeto especificado por el parametro id.
     */
    @Override
    public FoodEntity getFood(long id)
    {
        return this.load(FoodEntity.class, id);
    }

    /**
     * <h1>crearFood</h1>
     * <p>Guarda el objeto pasado como parametro</p>
     *
     * @param foodDto objeto que sera guardado en la base de datos
     */
    @Override
    public void createFood(FoodEntity foodDto)
    {
        this.save(foodDto);
    }

    /**
     * <h1>updateFood</h1>
     * <p>Metodo que actualiza un objeto de la base de datos</p>
     *
     * @param foodDto es el objeto que encapsula lo datos actualizados en la base de datos
     */
    @Override
    public void updateFood(FoodEntity foodDto)
    {
        if (this.load(FoodEntity.class, foodDto.getId()) != null)
            this.update(foodDto);
    }

    /**
     * <h1>deleteFood</h1>
     * <p>Elimina un elemento de la base de datos</p>
     *
     * @param id identificador el cual reprecenta el elemnto que se dea borrar
     */
    @Override
    public void deleteFood(long id)
    {
        FoodEntity foodEntity = this.load(FoodEntity.class, id);
        if (foodEntity != null)
            this.delete(foodEntity);
    }
}
