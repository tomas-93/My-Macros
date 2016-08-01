package com.mymacros.repository.dao.entity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodDailyRepositoryDao
{
     List<DailyFoodEntity> getAllFoodDaily(long id);
     DailyFoodEntity getFoodDaily(long id);
     void crateFoodDaily(DailyFoodEntity dailyFoodEntity);
     void updateFoodDaily(DailyFoodEntity dailyFoodEntity);
     void deleteFoodDaily(long id);
}
