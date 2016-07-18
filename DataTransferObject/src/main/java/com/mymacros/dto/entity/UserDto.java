package com.mymacros.dto.entity;


import java.time.Instant;

/**
 * Created by Tomas on 17/07/2016.
 */
public class UserDto
{
     private long id;
     private String name,
                    surname,
                    heigth,
                    width;
     private Instant timeDate;

     public UserDto() {
     }

     public UserDto(long id, String name, String surname, String heigth, String width, Instant timeDate) {
          this.id = id;
          this.name = name;
          this.surname = surname;
          this.heigth = heigth;
          this.width = width;
          this.timeDate = timeDate;
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
