package com.mymacros.dao.entity;

import com.mymacros.dto.entity.FoodRecipeDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRecipeDao
{
     List<FoodRecipeDto> getAllFoodRecipe();
     FoodRecipeDto getFoodRecipe(long id);
     void createFoodRecipe(FoodRecipeDto FoodRecipeDto);
     void updateFoodRecipe(FoodRecipeDto FoodRecipeDto);
     void deleteFoodRecipe(long id);
}
