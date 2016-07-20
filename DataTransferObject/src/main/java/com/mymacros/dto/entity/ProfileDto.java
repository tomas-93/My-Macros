package com.mymacros.dto.entity;

/**
 * Created by Tomas on 17/07/2016.
 */
public class ProfileDto
{
     private long id, idUser;
     private int carbs, fat, protein, fiber, totalCalories;

     public ProfileDto()
     {
     }

     public ProfileDto(long id, long idUser, int carbs, int fat, int protein, int fiber, int totalCalories)
     {
          this.id = id;
          this.idUser = idUser;
          this.carbs = carbs;
          this.fat = fat;
          this.protein = protein;
          this.fiber = fiber;
          this.totalCalories = totalCalories;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdUser() {
          return idUser;
     }

     public void setIdUser(long idUser) {
          this.idUser = idUser;
     }

     public int getCarbs() {
          return carbs;
     }

     public void setCarbs(int carbs) {
          this.carbs = carbs;
     }

     public int getFat() {
          return fat;
     }

     public void setFat(int fat) {
          this.fat = fat;
     }

     public int getProtein() {
          return protein;
     }

     public void setProtein(int protein) {
          this.protein = protein;
     }

     public int getFiber() {
          return fiber;
     }

     public void setFiber(int fiber) {
          this.fiber = fiber;
     }

     public int getTotalCalories() {
          return totalCalories;
     }

     public void setTotalCalories(int totalCalories) {
          this.totalCalories = totalCalories;
     }
}
