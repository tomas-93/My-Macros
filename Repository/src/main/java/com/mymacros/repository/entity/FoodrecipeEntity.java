package com.mymacros.repository.entity;

import javax.persistence.*;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "foodrecipe", schema = "mymacros")
public class FoodrecipeEntity
{
    private long id;
    private FoodEntity foodByIdFood;

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

        FoodrecipeEntity that = (FoodrecipeEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        return (int) (id ^ (id >>> 32));
    }

    @ManyToOne
    @JoinColumn(name = "idFood", referencedColumnName = "id")
    public FoodEntity getFoodByIdFood()
    {
        return foodByIdFood;
    }

    public void setFoodByIdFood(FoodEntity foodByIdFood)
    {
        this.foodByIdFood = foodByIdFood;
    }
}
