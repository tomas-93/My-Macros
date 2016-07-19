package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodRecipeDao;
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

     @Override
     public synchronized List<FoodRecipeDto> getAllFoodRecipe()
     {
          List<FoodRecipeDto> list = new ArrayList<FoodRecipeDto>();
          for(Long id: this.foodRecipeDatabase.keySet())
               list.add(this.foodRecipeDatabase.get(id));

          return list;
     }

     @Override
     public synchronized FoodRecipeDto getFoodRecipe(long id)
     {
          return this.foodRecipeDatabase.get(id);
     }

     @Override
     public synchronized void createFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          if (!this.foodRecipeDatabase.isEmpty())
               this.idFoodRecipe++;

          foodRecipeDto.setId(this.idFoodRecipe);
          this.foodRecipeDatabase.put(foodRecipeDto.getId(), foodRecipeDto);
     }

     @Override
     public synchronized void updateFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          this.foodRecipeDatabase.replace(foodRecipeDto.getId(),foodRecipeDto);
     }

     @Override
     public synchronized void deleteFoodRecipe(long id)
     {
          this.foodRecipeDatabase.remove(id);
     }
}
