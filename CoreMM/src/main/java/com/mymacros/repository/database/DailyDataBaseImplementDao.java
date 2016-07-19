package com.mymacros.repository.database;


import com.mymacros.dao.entity.DailyDao;
import com.mymacros.dto.entity.DailyDto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
public class DailyDataBaseImplementDao implements DailyDao
{
     private final Map<Long, DailyDto> dailyDtoMapDatabase = new Hashtable<Long, DailyDto>();
     private volatile long idDaily = 1L;

     public List<DailyDto> getAllDaily()
     {
          List<DailyDto> dailyDtoList = new ArrayList<DailyDto>();
          for(Long id: this.dailyDtoMapDatabase.keySet())
          {
               dailyDtoList.add(this.dailyDtoMapDatabase.get(id));
          }
          return dailyDtoList;
     }

     public DailyDto getDaily(long id)
     {
          return this.dailyDtoMapDatabase.get(id);
     }

     public void createDaily(DailyDto dailyDto)
     {
          if (!dailyDtoMapDatabase.isEmpty())
               this.idDaily ++;

          dailyDto.setId(idDaily);
          this.dailyDtoMapDatabase.put(dailyDto.getId(), dailyDto);
     }

     public void deleteDaily(long id)
     {
          this.dailyDtoMapDatabase.remove(id);
     }

     public void updateDaily(DailyDto dailyDto)
     {
          this.dailyDtoMapDatabase.replace(dailyDto.getId(), dailyDto);
     }
}
