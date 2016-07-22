package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class ProfileDto
{
     private long id, idUser;
     @NotNull
     @Min(0)
     @Valid
     private Integer carbs, fat, protein, fiber, totalCalories;

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

     public Integer getCarbs() {
          return carbs;
     }

     public void setCarbs(int carbs) {
          this.carbs = carbs;
     }

     public Integer getFat() {
          return fat;
     }

     public void setFat(int fat) {
          this.fat = fat;
     }

     public Integer getProtein() {
          return protein;
     }

     public void setProtein(int protein) {
          this.protein = protein;
     }

     public Integer getFiber() {
          return fiber;
     }

     public void setFiber(int fiber) {
          this.fiber = fiber;
     }

     public Integer getTotalCalories() {
          return totalCalories;
     }

     public void setTotalCalories(int totalCalories) {
          this.totalCalories = totalCalories;
     }
}
