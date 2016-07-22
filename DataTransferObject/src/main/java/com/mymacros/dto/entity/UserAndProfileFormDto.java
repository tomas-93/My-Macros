package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * Created by Tomas on 20/07/2016.
 */
public class UserAndProfileFormDto
{
     @NotNull
     @NotEmpty
     @Valid
     private String name,
             surname,
             heigth,
             width,
             userName,
             password;
     @NotNull
     @Min(0)
     @Valid
     private Integer carbs, fat, protein, fiber, totalCalories;
     @NotNull
     @Valid
     private Instant timeDate;

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSurname() {
          return surname;
     }

     public void setSurname(String surname) {
          this.surname = surname;
     }

     public String getHeigth() {
          return heigth;
     }

     public void setHeigth(String heigth) {
          this.heigth = heigth;
     }

     public String getWidth() {
          return width;
     }

     public void setWidth(String width) {
          this.width = width;
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

     public Instant getTimeDate() {
          return timeDate;
     }

     public void setTimeDate(Instant timeDate) {
          this.timeDate = timeDate;
     }
}
