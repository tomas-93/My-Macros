package com.mymacros.dto.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
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
                    height,
                    width,
                    email,
                    password;
     public UserDto()
     {
     }


     public UserDto(long id, String name, String surname, String height,
                    String width, String email, String password)
     {
          this.id = id;
          this.name = name;
          this.surname = surname;
          this.height = height;
          this.width = width;
          this.email = email;
          this.password = password;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String userName) {
          this.email = userName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getSurname() {
          return surname;
     }

     public void setSurname(String surname) {
          this.surname = surname;
     }

     public String getHeight() {
          return height;
     }

     public void setHeight(String height) {
          this.height = height;
     }

     public String getWidth() {
          return width;
     }

     public void setWidth(String width) {
          this.width = width;
     }

}
