package com.mymacros.dto.entity;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodDailyDto
{
     private long id, idDaily, idFood, idRecipe;
     private short numberFood;

     public FoodDailyDto() {
     }

     public FoodDailyDto(long id, long idDaily, long idFood, long idRecipe, short numberFood) {
          this.id = id;
          this.idDaily = idDaily;
          this.idFood = idFood;
          this.idRecipe = idRecipe;
          this.numberFood = numberFood;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdDaily() {
          return idDaily;
     }

     public void setIdDaily(long idDaily) {
          this.idDaily = idDaily;
     }

     public long getIdFood() {
          return idFood;
     }

     public void setIdFood(long idFood) {
          this.idFood = idFood;
     }

     public long getIdRecipe() {
          return idRecipe;
     }

     public void setIdRecipe(long idRecipe) {
          this.idRecipe = idRecipe;
     }

     public short getNumberFood() {
          return numberFood;
     }

     public void setNumberFood(short numberFood) {
          this.numberFood = numberFood;
     }

}
