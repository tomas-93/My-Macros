package com.mymacros.database.entity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.Timestamp;
import java.security.Principal;

/**
 * Created by Tomas on 29/07/2016.
 */
@Entity
@Table(name = "user", schema = "mymacros")
public class UserEntity implements Serializable,Principal
{
    private static final String SESSION_ATTRIBUTE_KEY = "com.mymacros.repository";

    private long id;
    private String userName;
    private String surname;
    private String birthday;
    private int height;
    private int weight;
    private Timestamp time;
    private byte[] password;
    private String email;

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
    @Column(name = "username", nullable = false, length = 50)
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String name)
    {
        this.userName = name;
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
    @Column(name = "birthday", nullable = false)
    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String brithday)
    {
        this.birthday = brithday;
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
    @Column(name = "password", nullable = false, length = 128)
    public byte[] getPassword()
    {
        return password;
    }

    public void setPassword( byte[] pasword)
    {
        this.password = pasword;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 50)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Transient
    public String getName()
    {
        return String.valueOf(this.getId());
    }


    public static Principal getPrincipal(HttpSession session)
    {
        return session == null ? null :
                (Principal)session.getAttribute(SESSION_ATTRIBUTE_KEY);
    }

    public static void setPrincipal(HttpSession session, Principal principal)
    {
        session.setAttribute(SESSION_ATTRIBUTE_KEY, principal);
    }
}
