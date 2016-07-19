package com.mymacros.dao.entity;

import com.mymacros.dto.entity.DailyDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface DailyDao
{
     List<DailyDto> getAllDaily();
     DailyDto getDaily(long id);
     void createDaily(DailyDto dailyDto);
     void deleteDaily(long id);
     void updateDaily(DailyDto dailyDto);

}
