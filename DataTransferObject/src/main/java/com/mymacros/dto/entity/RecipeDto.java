package com.mymacros.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class RecipeDto
{
     private long id, idMacros, idFoodRecipe;
     @NotNull
     @NotEmpty
     private String name, description;

     public RecipeDto() {
     }

     public RecipeDto(long id, long idMacros, long idFoodRecipe, String name, String description) {
          this.id = id;
          this.idMacros = idMacros;
          this.idFoodRecipe = idFoodRecipe;
          this.name = name;
          this.description = description;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdMacros() {
          return idMacros;
     }

     public void setIdMacros(long idMacros) {
          this.idMacros = idMacros;
     }

     public long getIdFoodRecipe() {
          return idFoodRecipe;
     }

     public void setIdFoodRecipe(long idFoodRecipe) {
          this.idFoodRecipe = idFoodRecipe;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

}
