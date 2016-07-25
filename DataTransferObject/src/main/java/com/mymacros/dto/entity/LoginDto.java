package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Tomas on 25/07/2016.
 */
public class LoginDto
{
     @NotNull
     @NotEmpty
     @Size(max = 50, min=5)
     @Valid
     private String userName, password;

     public LoginDto(String userName, String password)
     {
          this.userName = userName;
          this.password = password;
     }

     public LoginDto()
     {
     }

     public String getUserName()
     {
          return userName;
     }

     public void setUserName(String userName)
     {
          this.userName = userName;
     }

     public String getPassword()
     {
          return password;
     }

     public void setPassword(String password)
     {
          this.password = password;
     }
}
