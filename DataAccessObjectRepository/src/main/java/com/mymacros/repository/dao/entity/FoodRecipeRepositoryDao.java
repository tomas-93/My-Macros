package com.mymacros.repository.dao.entity;

import com.mymacros.repository.entity.FoodrecipeEntity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRecipeRepositoryDao
{
     List<FoodrecipeEntity> getAllFoodRecipe(long idUser);
     FoodrecipeEntity getFoodRecipe(long id);
     void createFoodRecipe(FoodrecipeEntity foodRecipeDto);
     void updateFoodRecipe(FoodrecipeEntity foodRecipeDto);
     void deleteFoodRecipe(long id);
}
