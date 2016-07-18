package com.mymacros.dto.entity;

import java.time.LocalDate;

/**
 * Created by Tomas on 17/07/2016.
 */
public class DailyDto
{
     private long id, idUser;
     private LocalDate localDate;
     private short totalFood;
     private int totalCaloriesConsumend;

     public DailyDto() {
     }

     public DailyDto(long id, long idUser, LocalDate localDate, short totalFood, int totalCaloriesConsumend) {
          this.id = id;
          this.idUser = idUser;
          this.localDate = localDate;
          this.totalFood = totalFood;
          this.totalCaloriesConsumend = totalCaloriesConsumend;
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

     public short getTotalFood() {
          return totalFood;
     }

     public void setTotalFood(short totalFood) {
          this.totalFood = totalFood;
     }

     public int getTotalCaloriesConsumend() {
          return totalCaloriesConsumend;
     }

     public void setTotalCaloriesConsumend(int totalCaloriesConsumend) {
          this.totalCaloriesConsumend = totalCaloriesConsumend;
     }

}
