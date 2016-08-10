package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Tomas on 17/07/2016.
 */
public class ProfileDto
{
    private long id, idUser;
    private UserDto userDto;
    private MacronutrientsDto macronutrientsDto;

    @NotNull
    @NotEmpty
    @Size(min = 5, max = 50)
    @Valid
    private String name;

    public ProfileDto()
    {
        macronutrientsDto = new MacronutrientsDto();
    }

    public ProfileDto(long id,
                      UserDto userDto,
                      MacronutrientsDto macronutrientsDto,
                      String name)
    {
        this.id = id;
        this.userDto = userDto;
        this.macronutrientsDto = macronutrientsDto;
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getIdUser()
    {
        return idUser;
    }

    public void setIdUser(long idUser)
    {
        this.idUser = idUser;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public UserDto getUserDto()
    {
        return userDto;
    }

    public void setUserDto(UserDto userDto)
    {
        this.userDto = userDto;
    }

    public MacronutrientsDto getMacronutrientsDto()
    {
        return macronutrientsDto;
    }

    public void setMacronutrientsDto(MacronutrientsDto macronutrientsDto)
    {
        this.macronutrientsDto = macronutrientsDto;
    }
}
