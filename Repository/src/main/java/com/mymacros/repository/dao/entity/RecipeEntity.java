package com.mymacros.repository.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "recipe", schema = "mymacros")
public class RecipeEntity
{
    private long id;
    private String name;
    private Timestamp time;
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

        RecipeEntity that = (RecipeEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    public UserEntity getUserByIdUser()
    {
        return this.userByIdUser;
    }
    public void setUserByIdUser(UserEntity userByIdUser)
    {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idMacros", referencedColumnName = "id")
    public MacrosEntity getMacrosEntity()
    {
        return macrosEntity;
    }

    public void setMacrosEntity(MacrosEntity macrosEntity)
    {
        this.macrosEntity = macrosEntity;
    }
}
