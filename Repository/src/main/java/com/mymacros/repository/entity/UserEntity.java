package com.mymacros.repository.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "user", schema = "mymacros")
public class UserEntity
{
    private long id;
    private String name;
    private String surname;
    private Date brithday;
    private int height;
    private int weight;
    private Timestamp time;
    private String pasword;

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
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Basic
    @Column(name = "brithday", nullable = false)
    public Date getBrithday()
    {
        return brithday;
    }

    public void setBrithday(Date brithday)
    {
        this.brithday = brithday;
    }

    @Basic
    @Column(name = "height", nullable = false, precision = 0)
    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
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

    @Basic
    @Column(name = "pasword", nullable = false, length = 128)
    public String getPasword()
    {
        return pasword;
    }

    public void setPasword(String pasword)
    {
        this.pasword = pasword;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (height != that.height) return false;
        if (weight != that.weight) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (brithday != null ? !brithday.equals(that.brithday) : that.brithday != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (pasword != null ? !pasword.equals(that.pasword) : that.pasword != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (brithday != null ? brithday.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (pasword != null ? pasword.hashCode() : 0);
        return result;
    }
}
