package com.mymacros.repository.database;

import com.mymacros.repository.dao.entity.FoodRecipeDao;
import com.mymacros.dto.entity.FoodRecipeDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodRecipeDataBaseImplementDao implements FoodRecipeDao
{
     private final Map<Long, FoodRecipeDto> foodRecipeDatabase =
             new Hashtable<Long, FoodRecipeDto>();
     private volatile long idFoodRecipe = 1L;

     /**
      * <h1>getAllFoodRecipe</h1>
      * <p>Obtiene una lista de la base de datos</p>
      * @return
      *
      */
     @Override
     public synchronized List<FoodRecipeDto> getAllFoodRecipe()
     {
          List<FoodRecipeDto> list = new ArrayList<FoodRecipeDto>();
          for(Long id: this.foodRecipeDatabase.keySet())
               list.add(this.foodRecipeDatabase.get(id));

          return list;
     }

     /**
      * <h1>getFoodRecipe</h1>
      * <p>Obtiene un elemento de la base de datos especificado por el id</p>
      * @param id Identificador que reprecenta el valor del objeto a buscar
      * @return retorna el objeto encontrado de la base de datos.
      */
     @Override
     public synchronized FoodRecipeDto getFoodRecipe(long id)
     {
          return this.foodRecipeDatabase.get(id);
     }

     /**
      * <h1>createFoodRrecipe</h1>
      * <p>Agrega un nuevo elemto a la base de datos</p>
      * @param foodRecipeDto elemeto que se agregara a la base de datos
      *
      */
     @Override
     public synchronized void createFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          if (!this.foodRecipeDatabase.isEmpty())
               this.idFoodRecipe++;

          foodRecipeDto.setId(this.idFoodRecipe);
          this.foodRecipeDatabase.put(foodRecipeDto.getId(), foodRecipeDto);
     }

     /**
      * <h1>updateFoodRecipe</h1>
      * <p>Actualiza un elemto en la base de datos</p>
      * @param foodRecipeDto objeto que encapsula el objeto a editar
      */
     @Override
     public synchronized void updateFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          this.foodRecipeDatabase.replace(foodRecipeDto.getId(),foodRecipeDto);
     }

     /**
      * <h1>deleteFoodRecipe</h1>
      * <p>Elomina un elemto de la base de datos</p>
      * @param id indetificador de la base de datos que representa el elemto a eliminar
      */
     @Override
     public synchronized void deleteFoodRecipe(long id)
     {
          this.foodRecipeDatabase.remove(id);
     }
}
