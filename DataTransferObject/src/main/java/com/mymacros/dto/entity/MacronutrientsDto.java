package com.mymacros.dto.entity;

/**
 * Created by Tomas on 17/07/2016.
 */
public class MacronutrientsDto
{
     private long id;
     private int totalCarbohydrates,
                    totalProtein,
                    totalFats,
                    fiber,
                    sugar,
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

     public int getTotalCarbohydrates() {
          return totalCarbohydrates;
     }

     public void setTotalCarbohydrates(int totalCarbohydrates) {
          this.totalCarbohydrates = totalCarbohydrates;
     }

     public int getTotalProtein() {
          return totalProtein;
     }

     public void setTotalProtein(int totalProtein) {
          this.totalProtein = totalProtein;
     }

     public int getTotalFats() {
          return totalFats;
     }

     public void setTotalFats(int totalFats) {
          this.totalFats = totalFats;
     }

     public int getFiber() {
          return fiber;
     }

     public void setFiber(int fiber) {
          this.fiber = fiber;
     }

     public int getSugar() {
          return sugar;
     }

     public void setSugar(int sugar) {
          this.sugar = sugar;
     }

     public int getSaturated() {
          return saturated;
     }

     public void setSaturated(int saturated) {
          this.saturated = saturated;
     }

     public int getMonounsaturated() {
          return monounsaturated;
     }

     public void setMonounsaturated(int monounsaturated) {
          this.monounsaturated = monounsaturated;
     }

     public int getPolyunsaturated() {
          return polyunsaturated;
     }

     public void setPolyunsaturated(int polyunsaturated) {
          this.polyunsaturated = polyunsaturated;
     }

}
