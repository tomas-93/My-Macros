package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Tomas on 17/07/2016.
 */
public class DailyDto
{
     private long id, idUser;
     @NotNull
     @Valid
     private LocalDate localDate;
     @NotNull
     @Min(0)
     @Max(10)
     @Valid
     private Short totalFood;
     @NotNull
     @Min(0)
     @Valid
     private Integer totalCaloriesConsumed;

     public DailyDto() {
     }

     public DailyDto(long id, long idUser, LocalDate localDate, short totalFood, int totalCaloriesConsumed) {
          this.id = id;
          this.idUser = idUser;
          this.localDate = localDate;
          this.totalFood = totalFood;
          this.totalCaloriesConsumed = totalCaloriesConsumed;
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

     public LocalDate getLocalDate() {
          return localDate;
     }

     public void setLocalDate(LocalDate localDate) {
          this.localDate = localDate;
     }

     public Short getTotalFood() {
          return totalFood;
     }

     public void setTotalFood(Short totalFood) {
          this.totalFood = totalFood;
     }

     public Integer getTotalCaloriesConsumed() {
          return totalCaloriesConsumed;
     }

     public void setTotalCaloriesConsumed(Integer totalCaloriesConsumed) {
          this.totalCaloriesConsumed = totalCaloriesConsumed;
     }

}
