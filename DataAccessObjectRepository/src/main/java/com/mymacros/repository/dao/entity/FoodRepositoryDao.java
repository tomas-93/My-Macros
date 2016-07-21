package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.FoodDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface FoodRepositoryDao extends IDBase
{
     List<FoodDto> getAllFood(long id);
     FoodDto getFood(long id);
     void createFood(FoodDto foodDto);
     void updateFood(FoodDto foodDto);
     void deleteFood(long id);
}
