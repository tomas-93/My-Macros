package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodDailyDao;
import com.mymacros.dto.entity.FoodDailyDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodDailyDataBaseImplementDao implements FoodDailyDao
{
     private final Map<Long, FoodDailyDto> foodDailyDatabase = new Hashtable<Long, FoodDailyDto>();
     private volatile long idFoodDaily = 1L;

     /**
      * <h1>getAllFoodDaily</h1>
      * <p>Metod donde se obtine todos los datos de la base de datos</p>
      * @return Retorna una lista de todos los objetos de la base de datos
      */
     @Override
     public List<FoodDailyDto> getAllFoodDaily()
     {
          List<FoodDailyDto> list = new ArrayList<FoodDailyDto>();
          for(Long id: this.foodDailyDatabase.keySet())
               list.add(this.foodDailyDatabase.get(id));
          return list;
     }

     /**
      * <h1>getFoodDaily</h1>
      * <p>Se obtiene un objeto en especifico</p>
      * @param id parametro que especifica el id del objeto que se quiere obtener
      * @return retorna el objeto buscado en la base de datos
      */
     @Override
     public FoodDailyDto getFoodDaily(long id)
     {
          return this.foodDailyDatabase.get(id);
     }

     /**
      * <h1>createFoodDaily</h1>
      * <p>Crea un nuevo elemento en la base de datos</p>
      * @param foodDailyDto Objeto que tiene los datos que seran almacenados en la base de datos
      */
     @Override
     public void crateFoodDaily(FoodDailyDto foodDailyDto)
     {
          if(!foodDailyDatabase.isEmpty())
               this.idFoodDaily++;

          foodDailyDto.setId(idFoodDaily);
          this.foodDailyDatabase.put(foodDailyDto.getId(), foodDailyDto);
     }

     /**
      * <h1>updateFoodDaily</h1>
      * <p>Actualiza un objeto enviado como parametro</p>
      * @param foodDailyDto Objeto que sera actializado en la base de datos
      */

     @Override
     public void updateFoodDaily(FoodDailyDto foodDailyDto)
     {
          this.foodDailyDatabase.replace(foodDailyDto.getId(), foodDailyDto);
     }

     /**
      * <h1>deleteFoodDaily</h1>
      * <p>Borra un elemento de la base de datos, especificado por el parametro</p>
      * @param id Identificador que especifica el elemnto de la base de datos.
      */

     @Override
     public void deleteFoodDaily(long id)
     {
          this.foodDailyDatabase.remove(id);
     }
}
