package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodRecipeDao;
import com.mymacros.dao.entity.RecipeDao;
import com.mymacros.dto.entity.RecipeDto;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class RecipeDataBaseImplementDao implements RecipeDao
{
     private final Map<Long, RecipeDto> recipeDtoDatabase = new Hashtable<>();
     private volatile long idRecipe = 1L;
     @Inject
     private FoodRecipeDao foodRecipeDao;

     @Override
     public List<RecipeDto> getAllRecipe()
     {
          return this.recipeDtoDatabase.keySet()
                  .stream()
                  .map(this.recipeDtoDatabase::get)
                  .collect(Collectors.toList());
     }

     @Override
     public RecipeDto getRecipeDto(long id)
     {
          return this.recipeDtoDatabase.get(id);
     }

     @Override
     public void createRecipe(RecipeDto recipeDto)
     {
          if(!this.recipeDtoDatabase.isEmpty())
               this.idRecipe++;
          recipeDto.setId(this.idRecipe);
          this.recipeDtoDatabase.put(recipeDto.getId(), recipeDto);
     }

     @Override
     public void updateRecipe(RecipeDto recipeDto)
     {
          this.recipeDtoDatabase.replace(recipeDto.getId(), recipeDto);
     }

     @Override
     public void deleteRecipe(long id)
     {
          this.recipeDtoDatabase.remove(id);
     }
}
