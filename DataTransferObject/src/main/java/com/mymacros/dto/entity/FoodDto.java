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
    private long id, idMacronutrients, idUser;
    @NotNull
    @NotEmpty
    @Valid
    private String name, brand, unit, type;
    @NotNull
    @Min(0)
    @Valid
    private Integer quantity;

    public FoodDto()
    {
    }

    public FoodDto(long id, long idMacronutrients, long idUser, String name, String brand, String unit, String type, Integer quantity)
    {
        this.id = id;
        this.idMacronutrients = idMacronutrients;
        this.idUser = idUser;
        this.name = name;
        this.brand = brand;
        this.unit = unit;
        this.type = type;
        this.quantity = quantity;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getIdMacronutrients()
    {
        return idMacronutrients;
    }

    public void setIdMacronutrients(long idMacronutrients)
    {
        this.idMacronutrients = idMacronutrients;
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

    public long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(long idUser)
    {
        this.idUser = idUser;
    }
}
