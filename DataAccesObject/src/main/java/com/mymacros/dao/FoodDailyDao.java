package com.mymacros.dao;

import com.mymacros.dto.entity.FoodDailyDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodDailyDao
{
     List<FoodDailyDto> getAllFoodDaily();
     FoodDailyDto getFoodDaily(long id);
     void crateFoodDaily(FoodDailyDto foodDailyDto);
     void deleteFoodDaily(long id);
}
