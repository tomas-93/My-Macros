package com.mymacros.services;

import com.mymacros.dto.entity.DailyDto;
import com.mymacros.dto.entity.FoodDailyDto;
import com.mymacros.repository.dao.entity.*;
import com.mymacros.services.dao.entity.DailyServicesDao;
import com.mymacros.services.util.Convert;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

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
    @Inject
    private MacronutrientsRepositoryDao macronutrientsRepositoryDao;

     /**
      * <h1>addDailyDto</h1>
      * <p>Agrega un nuevo elemeto al repositorio</p>
      *
      * @param dailyDto Objeto que encapsula los nuevos datos.
      */
     @Override
     public void addDailyDto(DailyDto dailyDto)
     {
         this.dailyRepositoryDao.createDaily(Convert.dailyEntity(dailyDto));
     }

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
         return Convert.dailyDto(this.dailyRepositoryDao.getDaily(id));
     }

     /**
      * <h1>getAllDaily</h1>
      * <p>Obtiene una lista de objetos DailyDto relacionados con el usuario</p>
      *
      * @param idUser Indetidicador que reprecenta la relacion entre el usuario y el entidad DailyDto
      * @return Retorna una lista de elemeto DailyDto relacionados con el usuario.
      */
     @Override
     public List<DailyDto> getAllDaily(long idUser)
     {
         return this.dailyRepositoryDao.getAllDaily(idUser)
                 .stream()
                 .map(Convert::dailyDto)
                 .collect(Collectors.toList());
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
         this.dailyRepositoryDao.updateDaily(Convert.dailyEntity(dailyDto));
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
         DailyEntity dailyEntity = this.dailyRepositoryDao.getDaily(id);
         this.dailyRepositoryDao.deleteDaily(id);
         this.foodDailyRepositoryDao.getAllFoodDaily(dailyEntity.getId())
                 .stream()
                 .map(DailyFoodEntity::getId)
                 .forEach(this.foodDailyRepositoryDao::deleteFoodDaily);
         this.macronutrientsRepositoryDao.deleteMacronutrients(dailyEntity.getMacrosEntity().getId());
     }

     /**
      * <h1>addFoodDailyDto</h1>
      * <p>Se agrega un nuevo elemeto al repositorio</p>
      *
      * @param foodDailyDto Objeto que en capsula la nueva informacion
      */
     @Override
     public void addFoodDailyDto(FoodDailyDto foodDailyDto)
     {
         this.foodDailyRepositoryDao.crateFoodDaily(Convert.foodDailyEntity(foodDailyDto));
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
         return Convert.foodDailyDto(this.foodDailyRepositoryDao.getFoodDaily(id));
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
         return this.foodDailyRepositoryDao.getAllFoodDaily(id)
                 .stream()
                 .map(Convert::foodDailyDto)
                 .collect(Collectors.toList());
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
         this.foodDailyRepositoryDao.updateFoodDaily(Convert.foodDailyEntity(foodDailyDto));
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
