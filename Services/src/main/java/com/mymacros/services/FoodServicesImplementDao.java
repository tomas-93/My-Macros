package com.mymacros.services;

import com.mymacros.dto.entity.FoodDto;
import com.mymacros.dto.entity.MacronutrientsDto;
import com.mymacros.repository.dao.entity.FoodRepositoryDao;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.services.dao.entity.FoodServicesDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
@Service
public class FoodServicesImplementDao implements FoodServicesDao
{
     @Inject
     private FoodRepositoryDao foodRepositoryDao;
     @Inject
     private MacronutrientsRepositoryDao macronutrientsRepositoryDao;

     /**
      * <h1>getFoodDto</h1>
      * <p>Obtiene el un objeto FoodDto del Repository</p>
      *
      * @param id Identificador que reprecenta el elemto a buscar
      * @return Retorna el elemento devuelto del repositorio
      */
     @Override
     public FoodDto getFoodDto(long id)
     {
          return this.foodRepositoryDao.getFood(id);
     }

     /**
      * <h1>addFoodDto</h1>
      * <p>Se agrega un nuevo objeto FoodDto al repositorio</p>
      *
      * @param foodDto Objeto que encapsula la nueva informacion.
      */
     @Override
     public void addFoodDto(FoodDto foodDto)
     {
          foodDto.setId(this.foodRepositoryDao.getIncrementID());
          this.foodRepositoryDao.createFood(foodDto);
     }

     /**
      * <h1>getAllFoodDto</h1>
      * <p>Obtiene una lista de todos lo elemto FoodDto del Repositorio</p>
      *
      * @return retorna un objeto list con todos los elemetos
      */
     @Override
     public List<FoodDto> getAllFoodDto(long idUser)
     {
          return this.foodRepositoryDao.getAllFood(idUser);
     }

     /**
      * <h1>updateFoodDto</h1>
      * <p>Actualiza un elemento del repostorio</p>
      *
      * @param foodDto Objeto que encapsula los datos actualizados
      */
     @Override
     public void updateFoodDto(FoodDto foodDto)
     {
          this.foodRepositoryDao.updateFood(foodDto);
     }

     /**
      * <h1>deleteFoodDto</h1>
      * <p>Elimina un elemeto del respositorio</p>
      *
      * @param id Identificador que reprecenta el elemento a eliminar.
      */
     @Override
     public void deleteFoodDto(long id)
     {
          this.foodRepositoryDao.deleteFood(id);
     }

     /**
      * <h1>addMacros</h1>
      * <p>Agrega un elemento a la base de datos </p>
      *
      * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
      */
     @Override
     public void addMacros(MacronutrientsDto macronutrientsDto)
     {
          macronutrientsDto.setId(this.macronutrientsRepositoryDao.getIncrementID());
          this.macronutrientsRepositoryDao.createMacronutrients(macronutrientsDto);
     }

     /**
      * <h1>getMacros</h1>
      * <p>Obtiene un objeto a partir de su indetificador que lo relaciona</p>
      *
      * @param id Indetificador que reprecenta la relacion del objeto a quien lo esta llamado
      * @return Retorna el objeto que se encuentra relacionad
      */
     @Override
     public MacronutrientsDto getMacros(long id)
     {
          return this.macronutrientsRepositoryDao.getMacronutrients(id);
     }

     /**
      * <h1>getAllMactos</h1>
      * <p>Obtiene una lista de elementos apartir del indetificador que los relaciona</p>
      *
      * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de elemetos.
      */
     @Override
     public List<MacronutrientsDto> getAllMacros(long id)
     {
          return this.macronutrientsRepositoryDao.getAllMacronutrients(id);
     }

     /**
      * <h1>updateMactos</h1>
      * <p>Actualiza un elemto de la base de datos</p>
      *
      * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
      */
     @Override
     public void updateMacros(MacronutrientsDto macronutrientsDto)
     {
          this.macronutrientsRepositoryDao.updateMacronutrients(macronutrientsDto);
     }

     /**
      * <h1>deleteMacros</h1>
      * <p>Da la orden al repositorio para eliminar un objeto</p>
      *
      * @param id Indetificador que reprecenta el obejto a eliminar.
      */
     @Override
     public void deleteMacros(long id)
     {
          this.macronutrientsRepositoryDao.deleteMacronutrients(id);
     }
}
