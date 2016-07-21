package com.mymacros.dto.entity;

import java.time.Instant;

/**
 * Created by Tomas on 20/07/2016.
 */
public class UserAndProfileFormDto
{
     private String name,
             surname,
             heigth,
             width;
     private int carbs, fat, protein, fiber, totalCalories;
     private Instant timeDate;

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

     public Instant getTimeDate() {
          return timeDate;
     }

     public void setTimeDate(Instant timeDate) {
          this.timeDate = timeDate;
     }
}
