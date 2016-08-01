package com.mymacros.repository.dao.database;

import com.mymacros.repository.dao.entity.DailyFoodEntity;
import com.mymacros.repository.dao.entity.FoodDailyRepositoryDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodDailyDataBaseImplementDao implements FoodDailyRepositoryDao
{
    @Inject
    private Session session;
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
                session.createQuery("from DailyFoodEntity inner join DailyEntity where  DailyFoodEntity.dailyByIdDaily = :idDaily")
                        .setParameter("idDaily",id)
                        .list();
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
        return this.session.load(DailyFoodEntity.class, id);
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
        this.session.save(dailyFoodEntity);
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
        if(this.session.load(DailyFoodEntity.class, dailyFoodEntity.getId()) != null)
            this.session.update(dailyFoodEntity);
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

        if(this.session.load(DailyFoodEntity.class, id) != null)
            this.session.remove(id);
    }

}
