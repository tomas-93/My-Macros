package com.mymacros.dto.entity;

import java.time.Instant;

/**
 * Created by Tomas on 17/07/2016.
 */
public class FoodDto
{
     private long id, idMacronutrients;
     private Instant timeDate;
     private String name, brand, unit, quantity;

     public FoodDto() {
     }

     public FoodDto(long id, long idMacronutrients, Instant timeDate, String name, String brand, String unit, String quantity) {
          this.id = id;
          this.idMacronutrients = idMacronutrients;
          this.timeDate = timeDate;
          this.name = name;
          this.brand = brand;
          this.unit = unit;
          this.quantity = quantity;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public long getIdMacronutrients() {
          return idMacronutrients;
     }

     public void setIdMacronutrients(long idMacronutrients) {
          this.idMacronutrients = idMacronutrients;
     }

     public Instant getTimeDate() {
          return timeDate;
     }

     public void setTimeDate(Instant timeDate) {
          this.timeDate = timeDate;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getBrand() {
          return brand;
     }

     public void setBrand(String brand) {
          this.brand = brand;
     }

     public String getUnit() {
          return unit;
     }

     public void setUnit(String unit) {
          this.unit = unit;
     }

     public String getQuantity() {
          return quantity;
     }

     public void setQuantity(String quantity) {
          this.quantity = quantity;
     }

}
