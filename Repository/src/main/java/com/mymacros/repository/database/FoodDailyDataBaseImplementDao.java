package com.mymacros.repository.database;

import com.mymacros.dto.entity.FoodDailyDto;
import com.mymacros.repository.dao.entity.FoodDailyRepositoryDao;
import org.springframework.stereotype.Repository;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodDailyDataBaseImplementDao implements FoodDailyRepositoryDao {
     private final Map<Long, FoodDailyDto> foodDailyDatabase = new Hashtable<Long, FoodDailyDto>();
     private volatile long idFoodDaily = 1L;

     /**
      * <h1>getAllFoodDaily</h1>
      * <p>Metod donde se obtine todos los datos de la base de datos</p>
      *
      * @return Retorna una lista de todos los objetos de la base de datos
      */
     @Override
     public List<FoodDailyDto> getAllFoodDaily(long idUser)
     {
          return this.foodDailyDatabase.keySet()
                  .stream()
                  .map(this.foodDailyDatabase::get)
                  .filter( foodDailyDto -> foodDailyDto.getId() == idUser)
                  .collect(Collectors.toList());
     }

     /**
      * <h1>getFoodDaily</h1>
      * <p>Se obtiene un objeto en especifico</p>
      *
      * @param id parametro que especifica el id del objeto que se quiere obtener
      * @return retorna el objeto buscado en la base de datos
      */
     @Override
     public FoodDailyDto getFoodDaily(long id) {
          return this.foodDailyDatabase.get(id);
     }

     /**
      * <h1>createFoodDaily</h1>
      * <p>Crea un nuevo elemento en la base de datos</p>
      *
      * @param foodDailyDto Objeto que tiene los datos que seran almacenados en la base de datos
      */
     @Override
     public void crateFoodDaily(FoodDailyDto foodDailyDto) {
          this.foodDailyDatabase.put(foodDailyDto.getId(), foodDailyDto);
     }

     /**
      * <h1>updateFoodDaily</h1>
      * <p>Actualiza un objeto enviado como parametro</p>
      *
      * @param foodDailyDto Objeto que sera actializado en la base de datos
      */

     @Override
     public void updateFoodDaily(FoodDailyDto foodDailyDto) {
          this.foodDailyDatabase.replace(foodDailyDto.getId(), foodDailyDto);
     }

     /**
      * <h1>deleteFoodDaily</h1>
      * <p>Borra un elemento de la base de datos, especificado por el parametro</p>
      *
      * @param id Identificador que especifica el elemnto de la base de datos.
      */

     @Override
     public void deleteFoodDaily(long id) {
          this.foodDailyDatabase.remove(id);
     }

     @Override
     public synchronized long getIncrementID() {
          return this.idFoodDaily++;
     }
}
