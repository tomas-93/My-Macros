package com.mymacros.dao;

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
     void deleteFoodRecipe(long id);
}
