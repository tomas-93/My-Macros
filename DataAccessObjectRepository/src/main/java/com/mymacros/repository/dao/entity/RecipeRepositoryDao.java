package com.mymacros.repository.dao.entity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface RecipeRepositoryDao
{
     List<RecipeEntity> getAllRecipe(long idUser);
     RecipeEntity getRecipeDto(long id);
     void createRecipe(RecipeEntity recipeDto);
     void updateRecipe(RecipeEntity recipeDto);
     void deleteRecipe(long id);
}
