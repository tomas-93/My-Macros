package com.mymacros.services;

import com.mymacros.dto.entity.DailyDto;
import com.mymacros.dto.entity.FoodDailyDto;
import com.mymacros.repository.dao.entity.DailyRepositoryDao;
import com.mymacros.repository.dao.entity.FoodDailyRepositoryDao;
import com.mymacros.services.dao.entity.DailyServicesDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
@Service
public class DailyServicesImplementDao implements DailyServicesDao
{
     @Inject
     private DailyRepositoryDao dailyRepositoryDao;
     @Inject
     private FoodDailyRepositoryDao foodDailyRepositoryDao;

     /**
      * <h1>getDailyDto</h1>
      * <p>Se obtiene un elemto del repositoy</p>
      *
      * @param id Indetificador que reprecenta el elemto a buscar
      * @return Retorna el elemto buscado en el respositorio
      */
     @Override
     public DailyDto getDailyDto(long id)
     {
          return this.dailyRepositoryDao.getDaily(id);
     }

     /**
      * <h1>getAllDaily</h1>
      * <p>Obtiene una lista de objetos DailyDto relacionados con el usuario</p>
      *
      * @param id Indetidicador que reprecenta la relacion entre el usuario y el entidad DailyDto
      * @return Retorna una lista de elemeto DailyDto relacionados con el usuario.
      */
     @Override
     public List<DailyDto> getAllDaily(long id)
     {
          return this.dailyRepositoryDao.getAllDaily();
     }

     /**
      * <h1>updateDailyDto</h1>
      * <p>Actualiza un objeto del repostorio</p>
      *
      * @param dailyDto Objeto que encapsula los datos actualizados.
      */
     @Override
     public void updateDailyDto(DailyDto dailyDto)
     {
          this.dailyRepositoryDao.updateDaily(dailyDto);
     }

     /**
      * <h1>deleteDailyDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      *
      * @param id Indetificador que reprecenta elemeto a eliminar.
      */
     @Override
     public void deleteDailyDto(long id)
     {
          this.dailyRepositoryDao.deleteDaily(id);
     }

     /**
      * <h1>getFoodDailyDto</h1>
      * <p>Se obtiene un elemto del repositoy</p>
      *
      * @param id Indetificador que reprecenta el elemto a buscar
      * @return Retorna el elemto buscado en el respositorio
      */
     @Override
     public FoodDailyDto getFoodDailyDto(long id)
     {
          return this.foodDailyRepositoryDao.getFoodDaily(id);
     }

     /**
      * <h1>getAllFoodDailyDto</h1>
      * <p>Obtiene una lista de objetos FoodDailyDto relacionados con el DailyDto</p>
      *
      * @param id Indetidicador que reprecenta la relacion entre el DailyDto y el entidad FoodDailyDto
      * @return Retorna una lista de elemeto FoodDailyDto relacionados con el DailyDto.
      */
     @Override
     public List<FoodDailyDto> getAllFoodDailyDto(long id)
     {
          return this.foodDailyRepositoryDao.getAllFoodDaily();
     }

     /**
      * <h1>updateFoodDailyDto</h1>
      * <p>Actualiza un objeto del repostorio</p>
      *
      * @param foodDailyDto Objeto que encapsula los datos actualizados.
      */
     @Override
     public void updateFoodDailyDto(FoodDailyDto foodDailyDto)
     {
          this.foodDailyRepositoryDao.updateFoodDaily(foodDailyDto);
     }

     /**
      * <h1>deleteFoodDailyDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      *
      * @param id Indetificador que reprecenta elemeto a eliminar.
      */
     @Override
     public void deleteFoodDailyDto(long id)
     {
          this.foodDailyRepositoryDao.deleteFoodDaily(id);
     }
}
