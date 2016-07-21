package com.mymacros.services.dao.entity;

import com.mymacros.dto.entity.FoodDto;

import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
public interface FoodServicesDao extends MacrosServicesDao
{
     /**
      * <h1>getFoodDto</h1>
      * <p>Obtiene el un objeto FoodDto del Repository</p>
      * @param id Identificador que reprecenta el elemto a buscar
      * @return Retorna el elemento devuelto del repositorio
      */
     FoodDto getFoodDto(long id);

     /**
      * <h1>getAllFoodDto</h1>
      * <p>Obtiene una lista de todos lo elemto FoodDto del Repositorio</p>
      * @return retorna un objeto list con todos los elemetos
      */
     List<FoodDto> getAllFoodDto();

     /**
      * <h1>updateFoodDto</h1>
      * <p>Actualiza un elemento del repostorio</p>
      * @param foodDto Objeto que encapsula los datos actualizados
      */
     void updateFoodDto(FoodDto foodDto);

     /**
      * <h1>deleteFoodDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      * @param id Identificador que reprecenta el elemento a eliminar.
      */
     void deleteFoodDto(long id);
}
