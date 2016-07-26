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
             height,
             width,
             email,
             password;
     @NotNull
     @Min(0)
     @Valid
     private Integer carbs, fat, protein, fiber, totalCalories;
     @NotNull
     @Valid
     private Instant timeDate;

     public UserAndProfileFormDto(String name, String surname, String height, String width,
                                  String email, String password, Integer carbs, Integer fat,
                                  Integer protein, Integer fiber, Integer totalCalories, Instant timeDate)
     {
          this.name = name;
          this.surname = surname;
          this.height = height;
          this.width = width;
          this.email = email;
          this.password = password;
          this.carbs = carbs;
          this.fat = fat;
          this.protein = protein;
          this.fiber = fiber;
          this.totalCalories = totalCalories;
          this.timeDate = timeDate;
     }

     public UserAndProfileFormDto()
     {
     }

     public String getName()
     {
          return name;
     }

     public void setName(String name)
     {
          this.name = name;
     }

     public String getSurname()
     {
          return surname;
     }

     public void setSurname(String surname)
     {
          this.surname = surname;
     }

     public String getHeight()
     {
          return height;
     }

     public void setHeight(String height)
     {
          this.height = height;
     }

     public String getWidth()
     {
          return width;
     }

     public void setWidth(String width)
     {
          this.width = width;
     }

     public String getEmail()
     {
          return email;
     }

     public void setEmail(String email)
     {
          this.email = email;
     }

     public String getPassword()
     {
          return password;
     }

     public void setPassword(String password)
     {
          this.password = password;
     }

     public Integer getCarbs()
     {
          return carbs;
     }

     public void setCarbs(Integer carbs)
     {
          this.carbs = carbs;
     }

     public Integer getFat()
     {
          return fat;
     }

     public void setFat(Integer fat)
     {
          this.fat = fat;
     }

     public Integer getProtein()
     {
          return protein;
     }

     public void setProtein(Integer protein)
     {
          this.protein = protein;
     }

     public Integer getFiber()
     {
          return fiber;
     }

     public void setFiber(Integer fiber)
     {
          this.fiber = fiber;
     }

     public Integer getTotalCalories()
     {
          return totalCalories;
     }

     public void setTotalCalories(Integer totalCalories)
     {
          this.totalCalories = totalCalories;
     }

     public Instant getTimeDate()
     {
          return timeDate;
     }

     public void setTimeDate(Instant timeDate)
     {
          this.timeDate = timeDate;
     }
}
