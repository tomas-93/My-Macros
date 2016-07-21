package com.mymacros.services.dao.entity;

import com.mymacros.dto.entity.DailyDto;
import com.mymacros.dto.entity.FoodDailyDto;

import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
public interface DailyServicesDao
{
     /**
      * ======================================================> <Daily>
      */
     /**
      * <h1>addDailyDto</h1>
      * <p>Agrega un nuevo elemeto al repositorio</p>
      * @param dailyDto Objeto que encapsula los nuevos datos.
      */
     void addDailyDto(DailyDto dailyDto);
     /**
      * <h1>getDailyDto</h1>
      * <p>Se obtiene un elemto del repositoy</p>
      * @param id Indetificador que reprecenta el elemto a buscar
      * @return Retorna el elemto buscado en el respositorio
      */
     DailyDto getDailyDto(long id);

     /**
      * <h1>getAllDaily</h1>
      * <p>Obtiene una lista de objetos DailyDto relacionados con el usuario</p>
      * @param id Indetidicador que reprecenta la relacion entre el usuario y el entidad DailyDto
      * @return Retorna una lista de elemeto DailyDto relacionados con el usuario.
      */
     List<DailyDto> getAllDaily(long id);

     /**
      * <h1>updateDailyDto</h1>
      * <p>Actualiza un objeto del repostorio</p>
      * @param dailyDto Objeto que encapsula los datos actualizados.
      */
     void updateDailyDto(DailyDto dailyDto);

     /**
      * <h1>deleteDailyDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      * @param id Indetificador que reprecenta elemeto a eliminar.
      */
     void deleteDailyDto(long id);
     /**
      *  ======================================================> <FoodDalily>
      */
     /**
      * <h1>addFoodDailyDto</h1>
      * <p>Se agrega un nuevo elemeto al repositorio</p>
      * @param foodDailyDto Objeto que en capsula la nueva informacion
      */
     void addFoodDailyDto(FoodDailyDto foodDailyDto);
     /**
      * <h1>getFoodDailyDto</h1>
      * <p>Se obtiene un elemto del repositoy</p>
      * @param id Indetificador que reprecenta el elemto a buscar
      * @return Retorna el elemto buscado en el respositorio
      */
     FoodDailyDto getFoodDailyDto(long id);

     /**
      * <h1>getAllFoodDailyDto</h1>
      * <p>Obtiene una lista de objetos FoodDailyDto relacionados con el DailyDto</p>
      * @param id Indetidicador que reprecenta la relacion entre el DailyDto y el entidad FoodDailyDto
      * @return Retorna una lista de elemeto FoodDailyDto relacionados con el DailyDto.
      */
     List<FoodDailyDto> getAllFoodDailyDto(long id);

     /**
      * <h1>updateFoodDailyDto</h1>
      * <p>Actualiza un objeto del repostorio</p>
      * @param foodDailyDto Objeto que encapsula los datos actualizados.
      */
     void updateFoodDailyDto(FoodDailyDto foodDailyDto);

     /**
      * <h1>deleteFoodDailyDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      * @param id Indetificador que reprecenta elemeto a eliminar.
      */
     void deleteFoodDailyDto(long id);


}
