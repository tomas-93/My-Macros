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
     private String email, password;

     public LoginDto(String email, String password)
     {
          this.email = email;
          this.password = password;
     }

     public LoginDto()
     {
     }

     public String getEmail()
     {
          return email;
     }

     public void setEmail(String email)
     {
          this.email = email;
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
