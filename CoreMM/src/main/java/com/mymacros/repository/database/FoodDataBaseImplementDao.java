package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodDao;
import com.mymacros.dao.entity.MacronutrientsDao;
import com.mymacros.dto.entity.FoodDto;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodDataBaseImplementDao implements FoodDao
{
     private Map<Long, FoodDto> foodDataBase = new Hashtable<Long, FoodDto>();
     private volatile long idFood = 1L;
     @Inject
     private MacronutrientsDao macronutrientsDto;

     /**
      * <h1>getAllFood</h1>
      * <p>Obtiene una lista de food de la base de datos</p>
      * @return Retorna una un objeto List que tiene una serie de objetos de la base de datos
      *
      */
     @Override
     public synchronized List<FoodDto> getAllFood()
     {
          List<FoodDto> list = new ArrayList<FoodDto>();
          for(Long id: this.foodDataBase.keySet())
               list.add(this.foodDataBase.get(id));

          return list;
     }

     /**
      * <h1>getFood</h1>
      * <p>Obtiene un dato de la base de datos</p>
      *
      * @param id especifica el identificador de un objeto guardado en la base de datos
      * @return retorna el objeto especificado por el parametro id.
      */
     @Override
     public synchronized FoodDto getFood(long id)
     {
          return this.foodDataBase.get(id);
     }

     /**
      * <h1>crearFood</h1>
      * <p>Guarda el objeto pasado como parametro</p>
      * @param foodDto objeto que sera guardado en la base de datos
      */
     @Override
     public synchronized void createFood(FoodDto foodDto)
     {
          if(!this.foodDataBase.isEmpty())
               this.idFood++;

          foodDto.setId(idFood);
          this.foodDataBase.put(foodDto.getId(), foodDto);

     }

     /**
      * <h1>updateFood</h1>
      * <p>Metodo que actualiza un objeto de la base de datos</p>
      * @param foodDto es el objeto que encapsula lo datos actualizados en la base de datos
      */
     @Override
     public synchronized void updateFood(FoodDto foodDto)
     {
          this.foodDataBase.replace(foodDto.getId(), foodDto);
     }

     /**
      * <h1>deleteFood</h1>
      * <p>Elimina un elemento de la base de datos</p>
      * @param id identificador el cual reprecenta el elemnto que se dea borrar
      */
     @Override
     public synchronized void deleteFood(long id)
     {
          final long idMacros = this.foodDataBase.get(id).getId();
          this.foodDataBase.remove(id);
          this.macronutrientsDto.deleteMacronutrients(idMacros);
     }
}
