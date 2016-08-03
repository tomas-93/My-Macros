package com.mymacros.database.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "daily", schema = "mymacros")
public class DailyEntity implements Serializable
{
    private long id;
    private UserEntity userByIdUser;
    private MacrosEntity macrosEntity;
    private int caloriesConsumed;
    private Timestamp time;


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
    @Column(name = "caloriesConsumed", nullable = false)
    public int getCaloriesConsumed()
    {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(int caloriesConsumed)
    {
        this.caloriesConsumed = caloriesConsumed;
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

        DailyEntity that = (DailyEntity) o;

        if (id != that.id) return false;
        if (caloriesConsumed != that.caloriesConsumed) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + caloriesConsumed;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    public UserEntity getUserByIdEntity()
    {
        return this.userByIdUser;
    }
    public void setUserByIdEntity(UserEntity userByIdEntity)
    {
        this.userByIdUser = userByIdEntity;
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
