package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class DailyDto
{
     private long id, idUser , idMacros;
     @NotNull
     @Min(0)
     @Valid
     private Integer totalCaloriesConsumed;

     public DailyDto() {
     }

    public DailyDto(long id, long idUser, long idMacros, Integer totalCaloriesConsumed)
    {
        this.id = id;
        this.idUser = idUser;
        this.idMacros = idMacros;
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

     public Integer getTotalCaloriesConsumed() {
          return totalCaloriesConsumed;
     }

     public void setTotalCaloriesConsumed(Integer totalCaloriesConsumed) {
          this.totalCaloriesConsumed = totalCaloriesConsumed;
     }

    public long getIdMacros()
    {
        return idMacros;
    }

    public void setIdMacros(long idMacros)
    {
        this.idMacros = idMacros;
    }
}
