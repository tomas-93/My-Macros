package com.mymacros.repository.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "foodrecipe", schema = "mymacros")
public class FoodRecipeEntity implements Serializable
{
    private long id;
    private RecipeEntity recipeByIdRecipe;
    private FoodEntity foodEntity;

    @Id
    @Column(name = "id", nullable = false)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodRecipeEntity that = (FoodRecipeEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return (int) (id ^ (id >>> 32));
    }

    @ManyToOne
    @JoinColumn(name = "idRecipe", referencedColumnName = "id")
    public RecipeEntity getRecipeByIdRecipe()
    {
        return recipeByIdRecipe;
    }

    public void setRecipeByIdRecipe(RecipeEntity recipeByIdRecipe)
    {
        this.recipeByIdRecipe = recipeByIdRecipe;
    }

    @ManyToOne
    @JoinColumn(name = "idFood", referencedColumnName = "id")
    public FoodEntity getFoodEntity()
    {
        return foodEntity;
    }

    public void setFoodEntity(FoodEntity foodEntity)
    {
        this.foodEntity = foodEntity;
    }
}
