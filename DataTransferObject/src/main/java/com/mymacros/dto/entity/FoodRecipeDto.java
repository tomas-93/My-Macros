package com.mymacros.dto.entity;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodRecipeDto
{
    private long id;
    private RecipeDto recipeDto;
    private FoodDto foodDto;

    public FoodRecipeDto()
    {
    }

    public FoodRecipeDto(long id, RecipeDto recipeDto, FoodDto foodDto)
    {
        this.id = id;
        this.recipeDto = recipeDto;
        this.foodDto = foodDto;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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
