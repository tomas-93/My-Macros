package com.mymacros.dto.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;

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
                    heigth,
                    width,
                    userName,
                    password;
     @NotNull
     @Valid
     private Instant timeDate;

     public UserDto()
     {
     }


     public UserDto(long id, String name, String surname, String heigth,
                    String width, String userName, String password, Instant timeDate)
     {
          this.id = id;
          this.name = name;
          this.surname = surname;
          this.heigth = heigth;
          this.width = width;
          this.userName = userName;
          this.password = password;
          this.timeDate = timeDate;
     }

     public String getUserName() {
          return userName;
     }

     public void setUserName(String userName) {
          this.userName = userName;
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

     public String getHeigth() {
          return heigth;
     }

     public void setHeigth(String heigth) {
          this.heigth = heigth;
     }

     public String getWidth() {
          return width;
     }

     public void setWidth(String width) {
          this.width = width;
     }

     public Instant getTimeDate() {
          return timeDate;
     }

     public void setTimeDate(Instant timeDate) {
          this.timeDate = timeDate;
     }


}
