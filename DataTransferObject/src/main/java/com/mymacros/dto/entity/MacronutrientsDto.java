package com.mymacros.dto.entity;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Tomas on 17/07/2016.
 */
public class MacronutrientsDto
{
     private long id;
     @NotNull
     @Min(50)
     @Valid
     private Integer totalCarbohydrates,
                    totalProtein,
                    totalFats,
                    fiber,
                    totalCal;

    private Integer sugar,
            saturated,
            monounsaturated,
            polyunsaturated;
     public MacronutrientsDto() {
     }

     public MacronutrientsDto(long id, int totalCarbohydrates, int totalProtein,
                              int totalFats, int fiber, int sugar, int saturated,
                              int monounsaturated, int polyunsaturated)
     {
          this.id = id;
          this.totalCarbohydrates = totalCarbohydrates;
          this.totalProtein = totalProtein;
          this.totalFats = totalFats;
          this.fiber = fiber;
          this.sugar = sugar;
          this.saturated = saturated;
          this.monounsaturated = monounsaturated;
          this.polyunsaturated = polyunsaturated;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     public Integer getTotalCarbohydrates() {
          return totalCarbohydrates;
     }

     public void setTotalCarbohydrates(Integer totalCarbohydrates) {
          this.totalCarbohydrates = totalCarbohydrates;
     }

     public Integer getTotalProtein() {
          return totalProtein;
     }

     public void setTotalProtein(int totalProtein) {
          this.totalProtein = totalProtein;
     }

     public Integer getTotalFats() {
          return totalFats;
     }

     public void setTotalFats(int totalFats) {
          this.totalFats = totalFats;
     }

     public Integer getFiber() {
          return fiber;
     }

     public void setFiber(int fiber) {
          this.fiber = fiber;
     }

     public Integer getSugar() {
          return sugar;
     }

     public void setSugar(int sugar) {
          this.sugar = sugar;
     }

     public Integer getSaturated() {
          return saturated;
     }

     public void setSaturated(int saturated) {
          this.saturated = saturated;
     }

     public Integer getMonounsaturated() {
          return monounsaturated;
     }

     public void setMonounsaturated(int monounsaturated) {
          this.monounsaturated = monounsaturated;
     }

     public Integer getPolyunsaturated() {
          return polyunsaturated;
     }

     public void setPolyunsaturated(int polyunsaturated) {
          this.polyunsaturated = polyunsaturated;
     }

    public Integer getTotalCal()
    {
        return totalCal;
    }

    public void setTotalCal(Integer totalCal)
    {
        this.totalCal = totalCal;
    }
}
