package com.mymacros.repository.database;

import com.mymacros.dao.FoodDailyDao;
import com.mymacros.dao.FoodRecipeDao;
import com.mymacros.dto.entity.FoodRecipeDto;

import java.util.List;

/**
 * Created by Tomas on 18/07/2016.
 */
public class FoodRecipeDataBaseImplementDao implements FoodRecipeDao {
     public List<FoodRecipeDto> getAllFoodRecipe() {
          return null;
     }

     public FoodRecipeDto getFoodRecipe(long id) {
          return null;
     }

     public void createFoodRecipe(FoodRecipeDto FoodRecipeDto) {

     }

     public void deleteFoodRecipe(long id) {

     }
}
