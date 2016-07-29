package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.FoodRecipeDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRecipeRepositoryDao
{
     List<FoodRecipeDto> getAllFoodRecipe(long idUser);
     FoodRecipeDto getFoodRecipe(long id);
     void createFoodRecipe(FoodRecipeDto foodRecipeDto);
     void updateFoodRecipe(FoodRecipeDto foodRecipeDto);
     void deleteFoodRecipe(long id);
}
