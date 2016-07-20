package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.RecipeDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface RecipeRepositoryDao
{
     List<RecipeDto> getAllRecipe();
     RecipeDto getRecipeDto(long id);
     void createRecipe(RecipeDto recipeDto);
     void updateRecipe(RecipeDto recipeDto);
     void deleteRecipe(long id);
}
