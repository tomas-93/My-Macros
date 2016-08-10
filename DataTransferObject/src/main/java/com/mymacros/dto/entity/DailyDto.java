package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class DailyDto
{
     private long id;
     private UserDto userDto;
     private MacronutrientsDto macronutrientsDto;
     @NotNull
     @Min(0)
     @Valid
     private Integer totalCaloriesConsumed;

     public DailyDto() {
     }

    public DailyDto(long id, UserDto userDto, MacronutrientsDto macronutrientsDto, Integer totalCaloriesConsumed)
    {
        this.id = id;
        this.userDto = userDto;
        this.macronutrientsDto = macronutrientsDto;
        this.totalCaloriesConsumed = totalCaloriesConsumed;
    }

    public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public Integer getTotalCaloriesConsumed() {
          return totalCaloriesConsumed;
     }

     public void setTotalCaloriesConsumed(Integer totalCaloriesConsumed) {
          this.totalCaloriesConsumed = totalCaloriesConsumed;
     }

    public MacronutrientsDto getMacronutrientsDto()
    {
        return macronutrientsDto;
    }

    public void setMacronutrientsDto(MacronutrientsDto macronutrientsDto)
    {
        this.macronutrientsDto = macronutrientsDto;
    }

    public UserDto getUserDto()
    {
        return userDto;
    }

    public void setUserDto(UserDto userDto)
    {
        this.userDto = userDto;
    }
}
