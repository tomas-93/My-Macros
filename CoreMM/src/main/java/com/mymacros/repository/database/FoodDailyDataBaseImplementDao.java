package com.mymacros.repository.database;

import com.mymacros.dao.entity.FoodDailyDao;
import com.mymacros.dto.entity.FoodDailyDto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
public class FoodDailyDataBaseImplementDao implements FoodDailyDao
{
     private final Map<Long, FoodDailyDto> foodDailyDatabase = new Hashtable<Long, FoodDailyDto>();
     private volatile long idFoodDaily = 1L;
     @Override
     public List<FoodDailyDto> getAllFoodDaily()
     {
          List<FoodDailyDto> list = new ArrayList<FoodDailyDto>();
          for(Long id: this.foodDailyDatabase.keySet())
               list.add(this.foodDailyDatabase.get(id));
          return list;
     }

     @Override
     public FoodDailyDto getFoodDaily(long id)
     {
          return this.foodDailyDatabase.get(id);
     }

     @Override
     public void crateFoodDaily(FoodDailyDto foodDailyDto)
     {
          if(!foodDailyDatabase.isEmpty())
               this.idFoodDaily++;

          foodDailyDto.setId(idFoodDaily);
          this.foodDailyDatabase.put(foodDailyDto.getId(), foodDailyDto);
     }

     @Override
     public void updateFoodDaily(FoodDailyDto foodDailyDto)
     {
          this.foodDailyDatabase.replace(foodDailyDto.getId(), foodDailyDto);
     }

     @Override
     public void deleteFoodDaily(long id)
     {
          this.foodDailyDatabase.remove(id);
     }
}
