package com.mymacros.dto.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class UserDto
{
    private long id;
    @NotNull
    @NotEmpty
    @Valid
    private String name,
            surname,
            email,
            password, repeatPassword;
    @NotNull
    @Max(200)
    @Min(0)
    @Valid
    private Integer height,
            weight;

    @NotNull
    @Valid
    private String birthday;

    public UserDto()
    {
    }

    public UserDto(long id, String name, String surname, String email, String password, String repeatPassword, Integer height, Integer weight, String birthday)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday  = birthday;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String userName)
    {
        this.email = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getRepeatPassword()
    {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword)
    {
        this.repeatPassword = repeatPassword;
    }
}
