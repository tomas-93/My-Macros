package com.mymacros.repository.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "dailyfood", schema = "mymacros")
public class DailyFoodEntity implements Serializable
{
    private long id;
    private short numberFood;
    private Timestamp time;
    private DailyEntity dailyByIdDaily;
    private RecipeEntity recipeByIdrecipe;
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

    @Basic
    @Column(name = "numberFood", nullable = false)
    public short getNumberFood()
    {
        return numberFood;
    }

    public void setNumberFood(short numberFood)
    {
        this.numberFood = numberFood;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime()
    {
        return time;
    }

    public void setTime(Timestamp time)
    {
        this.time = time;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DailyFoodEntity that = (DailyFoodEntity) o;

        if (id != that.id) return false;
        if (numberFood != that.numberFood) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + numberFood;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idDaily", referencedColumnName = "id")
    public DailyEntity getDailyByIdDaily()
    {
        return dailyByIdDaily;
    }

    public void setDailyByIdDaily(DailyEntity dailyByIdDaily)
    {
        this.dailyByIdDaily = dailyByIdDaily;
    }

    @ManyToOne
    @JoinColumn(name = "idRecipe", referencedColumnName = "id")
    public RecipeEntity getRecipeByIdrecipe()
    {
        return recipeByIdrecipe;
    }

    public void setRecipeByIdrecipe(RecipeEntity recipeByIdrecipe)
    {
        this.recipeByIdrecipe = recipeByIdrecipe;
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
