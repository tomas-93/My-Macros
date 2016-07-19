package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodDao;
import com.mymacros.dto.entity.FoodDto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
public class FoodDataBaseImplementDao implements FoodDao
{
     private Map<Long, FoodDto> foodDataBase = new Hashtable<Long, FoodDto>();
     private volatile long idFood = 1L;

     @Override
     public List<FoodDto> getAllFood()
     {
          List<FoodDto> list = new ArrayList<FoodDto>();
          for(Long id: this.foodDataBase.keySet())
               list.add(this.foodDataBase.get(id));

          return list;
     }

     @Override
     public FoodDto getFood(long id)
     {
          return this.foodDataBase.get(id);
     }
     @Override
     public void createFood(FoodDto foodDto)
     {
          if(!this.foodDataBase.isEmpty())
               this.idFood++;

          foodDto.setId(idFood);
          this.foodDataBase.put(foodDto.getId(), foodDto);

     }
     @Override
     public void updateFood(FoodDto foodDto)
     {
          this.foodDataBase.replace(foodDto.getId(), foodDto);
     }
     @Override
     public void deleteFood(long id)
     {
          this.foodDataBase.remove(id);
     }
}
