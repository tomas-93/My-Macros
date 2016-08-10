package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodDailyDto
{
    private long id, idDaily, idFood, idRecipe;
    private DailyDto dailyDto;
    private RecipeDto recipeDto;
    private FoodDto foodDto;
    @NotNull
    @Min(0)
    @Valid
    private Short numberFood;

    public FoodDailyDto()
    {
    }

    public FoodDailyDto(long id, long idDaily, long idFood, long idRecipe, short numberFood)
    {
        this.id = id;
        this.idDaily = idDaily;
        this.idFood = idFood;
        this.idRecipe = idRecipe;
        this.numberFood = numberFood;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getIdDaily()
    {
        return idDaily;
    }

    public void setIdDaily(long idDaily)
    {
        this.idDaily = idDaily;
    }

    public long getIdFood()
    {
        return idFood;
    }

    public void setIdFood(long idFood)
    {
        this.idFood = idFood;
    }

    public long getIdRecipe()
    {
        return idRecipe;
    }

    public void setIdRecipe(long idRecipe)
    {
        this.idRecipe = idRecipe;
    }

    public Short getNumberFood()
    {
        return numberFood;
    }

    public void setNumberFood(Short numberFood)
    {
        this.numberFood = numberFood;
    }

    public DailyDto getDailyDto()
    {
        return dailyDto;
    }

    public void setDailyDto(DailyDto dailyDto)
    {
        this.dailyDto = dailyDto;
    }

    public RecipeDto getRecipeDto()
    {
        return recipeDto;
    }

    public void setRecipeDto(RecipeDto recipeDto)
    {
        this.recipeDto = recipeDto;
    }

    public FoodDto getFoodDto()
    {
        return foodDto;
    }

    public void setFoodDto(FoodDto foodDto)
    {
        this.foodDto = foodDto;
    }
}
