package com.mymacros.repository.dao.entity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface DailyRepositoryDao
{
     List<DailyEntity> getAllDaily(long idDaily);
     DailyEntity getDaily(long id);
     void createDaily(DailyEntity dailyDto);
     void deleteDaily(long id);
     void updateDaily(DailyEntity dailyDto);
}
