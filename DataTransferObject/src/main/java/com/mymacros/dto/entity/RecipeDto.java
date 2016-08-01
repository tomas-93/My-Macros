package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class RecipeDto
{
     private long id, idUser, idMacros;
     @NotNull
     @NotEmpty
     private String name;

     public RecipeDto() {
     }

     public RecipeDto(long id, long idUser, long idMacros, String name) {
          this.id = id;
          this.idUser = idUser;
          this.idMacros = idMacros;
          this.name = name;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdUser() {
          return idUser;
     }

     public void setIdUser(long idUser) {
          this.idUser = idUser;
     }

     public long getIdMacros() {
          return idMacros;
     }

     public void setIdMacros(long idMacros) {
          this.idMacros = idMacros;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

}
