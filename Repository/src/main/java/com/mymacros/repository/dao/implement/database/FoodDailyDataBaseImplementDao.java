package com.mymacros.repository.dao.implement.database;

import com.mymacros.repository.dao.entity.FoodDailyRepositoryDao;
import com.mymacros.database.entity.DailyFoodEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * @author Tomas Yussef Galicia Guazman
 */
@Repository
public class FoodDailyDataBaseImplementDao extends HibernateTemplate implements FoodDailyRepositoryDao
{
    @Inject
    public FoodDailyDataBaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }

    /**
     * <h1>getAllFoodDaily</h1>
     * <p>Metod donde se obtine todos los datos de la base de datos</p>
     *
     * @return Retorna una lista de todos los objetos de la base de datos
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DailyFoodEntity> getAllFoodDaily(long id)
    {
        return (List<DailyFoodEntity>)
                this.find("from DailyFoodEntity inner join DailyEntity where  DailyFoodEntity.dailyByIdDaily = :idDaily", id);
    }

    /**
     * <h1>getFoodDaily</h1>
     * <p>Se obtiene un objeto en especifico</p>
     *
     * @param id parametro que especifica el id del objeto que se quiere obtener
     * @return retorna el objeto buscado en la base de datos
     */
    @Override
    public DailyFoodEntity getFoodDaily(long id)
    {
        return this.load(DailyFoodEntity.class, id);
    }

    /**
     * <h1>createFoodDaily</h1>
     * <p>Crea un nuevo elemento en la base de datos</p>
     *
     * @param dailyFoodEntity Objeto que tiene los datos que seran almacenados en la base de datos
     */
    @Override
    public void crateFoodDaily(DailyFoodEntity dailyFoodEntity)
    {
        this.save(dailyFoodEntity);
    }

    /**
     * <h1>updateFoodDaily</h1>
     * <p>Actualiza un objeto enviado como parametro</p>
     *
     * @param dailyFoodEntity Objeto que sera actializado en la base de datos
     */

    @Override
    public void updateFoodDaily(DailyFoodEntity dailyFoodEntity)
    {
        if (this.load(DailyFoodEntity.class, dailyFoodEntity.getId()) != null)
            this.update(dailyFoodEntity);
    }

    /**
     * <h1>deleteFoodDaily</h1>
     * <p>Borra un elemento de la base de datos, especificado por el parametro</p>
     *
     * @param id Identificador que especifica el elemnto de la base de datos.
     */

    @Override
    public void deleteFoodDaily(long id)
    {
        DailyFoodEntity dailyFoodEntity = this.load(DailyFoodEntity.class, id);
        if (dailyFoodEntity != null)
            this.delete(dailyFoodEntity);
    }

}
