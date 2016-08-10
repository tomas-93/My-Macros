package com.mymacros.database.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tomas on 01/08/2016.
 */
@Entity
@Table(name = "macros", schema = "mymacros")
public class MacrosEntity implements Serializable
{
    private long id;
    private Integer carbs;
    private Integer fat;
    private Integer protein;
    private Integer fiber;
    private int totalCalorie;
    private Integer sugar;
    private Integer saturated;
    private Integer monounsaturated;
    private Integer polyunsaturated;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "carbs", nullable = true)
    public Integer getCarbs()
    {
        return carbs;
    }

    public void setCarbs(Integer carbs)
    {
        this.carbs = carbs;
    }

    @Basic
    @Column(name = "fat", nullable = true)
    public Integer getFat()
    {
        return fat;
    }

    public void setFat(Integer fat)
    {
        this.fat = fat;
    }

    @Basic
    @Column(name = "protein", nullable = true)
    public Integer getProtein()
    {
        return protein;
    }

    public void setProtein(Integer protein)
    {
        this.protein = protein;
    }

    @Basic
    @Column(name = "fiber", nullable = true)
    public Integer getFiber()
    {
        return fiber;
    }

    public void setFiber(Integer fiber)
    {
        this.fiber = fiber;
    }

    @Basic
    @Column(name = "totalCalorie", nullable = false)
    public int getTotalCalorie()
    {
        return totalCalorie;
    }

    public void setTotalCalorie(int totalCalorie)
    {
        this.totalCalorie = totalCalorie;
    }

    @Basic
    @Column(name = "sugar", nullable = true)
    public Integer getSugar()
    {
        return sugar;
    }

    public void setSugar(Integer sugar)
    {
        this.sugar = sugar;
    }

    @Basic
    @Column(name = "saturated", nullable = true)
    public Integer getSaturated()
    {
        return saturated;
    }

    public void setSaturated(Integer saturated)
    {
        this.saturated = saturated;
    }

    @Basic
    @Column(name = "monounsaturated", nullable = true)
    public Integer getMonounsaturated()
    {
        return monounsaturated;
    }

    public void setMonounsaturated(Integer monounsaturated)
    {
        this.monounsaturated = monounsaturated;
    }

    @Basic
    @Column(name = "polyunsaturated", nullable = true)
    public Integer getPolyunsaturated()
    {
        return polyunsaturated;
    }

    public void setPolyunsaturated(Integer polyunsaturated)
    {
        this.polyunsaturated = polyunsaturated;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MacrosEntity that = (MacrosEntity) o;

        if (id != that.id) return false;
        if (totalCalorie != that.totalCalorie) return false;
        if (carbs != null ? !carbs.equals(that.carbs) : that.carbs != null) return false;
        if (fat != null ? !fat.equals(that.fat) : that.fat != null) return false;
        if (protein != null ? !protein.equals(that.protein) : that.protein != null) return false;
        if (fiber != null ? !fiber.equals(that.fiber) : that.fiber != null) return false;
        if (sugar != null ? !sugar.equals(that.sugar) : that.sugar != null) return false;
        if (saturated != null ? !saturated.equals(that.saturated) : that.saturated != null) return false;
        if (monounsaturated != null ? !monounsaturated.equals(that.monounsaturated) : that.monounsaturated != null)
            return false;
        if (polyunsaturated != null ? !polyunsaturated.equals(that.polyunsaturated) : that.polyunsaturated != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (carbs != null ? carbs.hashCode() : 0);
        result = 31 * result + (fat != null ? fat.hashCode() : 0);
        result = 31 * result + (protein != null ? protein.hashCode() : 0);
        result = 31 * result + (fiber != null ? fiber.hashCode() : 0);
        result = 31 * result + totalCalorie;
        result = 31 * result + (sugar != null ? sugar.hashCode() : 0);
        result = 31 * result + (saturated != null ? saturated.hashCode() : 0);
        result = 31 * result + (monounsaturated != null ? monounsaturated.hashCode() : 0);
        result = 31 * result + (polyunsaturated != null ? polyunsaturated.hashCode() : 0);
        return result;
    }
}
