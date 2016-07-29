package com.mymacros.repository.dao.entity;

import com.mymacros.repository.entity.FoodEntity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRepositoryDao
{
     List<FoodEntity> getAllFood(long id);
     FoodEntity getFood(long id);
     void createFood(FoodEntity foodDto);
     void updateFood(FoodEntity foodDto);
     void deleteFood(long id);
}
