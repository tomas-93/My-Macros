package com.mymacros.dto.entity;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodRecipeDto
{
     private long id, idRecipe, idFood;

     public FoodRecipeDto() {
     }

     public FoodRecipeDto(long id, long idRecipe, long idFood) {
          this.id = id;
          this.idRecipe = idRecipe;
          this.idFood = idFood;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdRecipe() {
          return idRecipe;
     }

     public void setIdRecipe(long idRecipe) {
          this.idRecipe = idRecipe;
     }

     public long getIdFood() {
          return idFood;
     }

     public void setIdFood(long idFood) {
          this.idFood = idFood;
     }
}
