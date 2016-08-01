package com.mymacros.repository.entity;

import javax.persistence.*;

/**
 * Created by Tomas on 01/08/2016.
 */
@Entity
@Table(name = "food", schema = "mymacros")
public class FoodEntity
{
    private long id;
    private String name;
    private String brand;
    private String unit;
    private int quantity;
    private String type;
    private UserEntity userByIdUser;
    private MacrosEntity macrosEntity;

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
    @Column(name = "name", nullable = false, length = 50)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 50)
    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    @Basic
    @Column(name = "unit", nullable = false, length = 5)
    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    @Basic
    @Column(name = "quantity", nullable = false, precision = 0)
    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 50)
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (id != that.id) return false;
        if (quantity != that.quantity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    public UserEntity getUserByIdUser()
    {
        return userByIdUser;
    }
    public void setUserByIdUser(UserEntity userByIdUser)
    {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idMacros", referencedColumnName = "id")
    public MacrosEntity getMacrosEntity()
    {
        return this.macrosEntity;
    }

    public void setMacrosEntity(MacrosEntity macrosEntity)
    {
        this.macrosEntity = macrosEntity;
    }
}
