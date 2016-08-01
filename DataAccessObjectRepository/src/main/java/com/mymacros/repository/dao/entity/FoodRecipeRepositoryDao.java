package com.mymacros.repository.dao.entity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRecipeRepositoryDao
{
     List<FoodRecipeEntity> getAllFoodRecipe(long idRecipe);
     FoodRecipeEntity getFoodRecipe(long id);
     void createFoodRecipe(FoodRecipeEntity foodRecipeDto);
     void updateFoodRecipe(FoodRecipeEntity foodRecipeDto);
     void deleteFoodRecipe(long id);
}
