package com.mymacros.repository.database;


import com.mymacros.repository.dao.entity.DailyRepositoryDao;
import com.mymacros.dto.entity.DailyDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class DailyDataBaseImplementDao implements DailyRepositoryDao
{
     private final Map<Long, DailyDto> dailyDtoMapDatabase = new Hashtable<Long, DailyDto>();
     private volatile long idDaily = 1L;

     /**
      * <h1>getAllDaily</h1>
      * <p>Se obtienen todos lo usuarios de la base de datso</p>
      * @return Retorna una lista del objecto DailyDto
      */
     @Override
     public List<DailyDto> getAllDaily(long idDaily)
     {
          //TODO buscar elemetos deacuerod al idDaily
          List<DailyDto> dailyDtoList = new ArrayList<>();
          for(Long id: this.dailyDtoMapDatabase.keySet())
          {
               dailyDtoList.add(this.dailyDtoMapDatabase.get(id));
          }
          return dailyDtoList;
     }

     /**
      * <h1>getDaily</h1>
      * <p>Se obtiene un objecto especifico de la base de datos</p>
      * @param id Este parametro es el valor del id de objecto que se quiere obtener
      * @return El objecto que se obtuvo de la base detos
      */
     @Override
     public DailyDto getDaily(long id)
     {
          return this.dailyDtoMapDatabase.get(id);
     }

     /**
      * <h1>createDaily</h1>
      * <p>Se almacena un objeto DailyDto a la base de datos</p>
      * @param dailyDto entidad que sera almacenado en la base de datos
      */
     @Override
     public void createDaily(DailyDto dailyDto)
     {
          this.dailyDtoMapDatabase.put(dailyDto.getId(), dailyDto);
     }

     /**
      * <h1>deleteDaily</h1>
      * <p>Elimina un objeto diario de la base de datos</p>
      * @param id indetificador de la entidad que sera eliminada
      */
     @Override
     public void deleteDaily(long id)
     {
          this.dailyDtoMapDatabase.remove(id);
     }

     /**
      * <h1>updateDaily</h1>
      * <p>Actualiza un objeto de la base de datos</p>
      * @param dailyDto entidad que contendra los datos actualizados
      */
     @Override
     public void updateDaily(DailyDto dailyDto)
     {
          this.dailyDtoMapDatabase.replace(dailyDto.getId(), dailyDto);
     }

     @Override
     public synchronized long getIncrementID()
     {
          return this.idDaily++;
     }
}
