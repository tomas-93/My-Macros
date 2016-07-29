package com.mymacros.repository.dao.entity;

import com.mymacros.repository.entity.FoodEntity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodDailyRepositoryDao
{
     List<FoodEntity> getAllFoodDaily(long idUser);
     FoodEntity getFoodDaily(long id);
     void crateFoodDaily(FoodEntity foodDailyDto);
     void updateFoodDaily(FoodEntity foodDailyDto);
     void deleteFoodDaily(long id);
}
