package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodDto
{
    private long id;
    private UserDto userDto;
    private MacronutrientsDto macronutrientsDto;
    @NotNull
    @NotEmpty
    @Valid
    private String name, brand, unit;
    @NotNull
    @Min(0)
    @Valid
    private Integer quantity;

    public FoodDto()
    {
        this.macronutrientsDto = new MacronutrientsDto();
    }

    public FoodDto(long id, UserDto userDto, MacronutrientsDto macronutrientsDto, String name, String brand, String unit, String type, Integer quantity)
    {
        this.id = id;
        this.userDto = userDto;
        this.macronutrientsDto = macronutrientsDto;
        this.name = name;
        this.brand = brand;
        this.unit = unit;
        this.quantity = quantity;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public UserDto getUserDto()
    {
        return userDto;
    }

    public void setUserDto(UserDto userDto)
    {
        this.userDto = userDto;
    }

    public MacronutrientsDto getMacronutrientsDto()
    {
        return macronutrientsDto;
    }

    public void setMacronutrientsDto(MacronutrientsDto macronutrientsDto)
    {
        this.macronutrientsDto = macronutrientsDto;
    }
}
