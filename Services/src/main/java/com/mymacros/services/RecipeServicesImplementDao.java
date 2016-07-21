package com.mymacros.services;

import com.mymacros.dto.entity.FoodRecipeDto;
import com.mymacros.dto.entity.MacronutrientsDto;
import com.mymacros.dto.entity.RecipeDto;
import com.mymacros.repository.dao.entity.FoodRecipeRepositoryDao;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.repository.dao.entity.RecipeRepositoryDao;
import com.mymacros.services.dao.entity.RecipeServicesDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
@Service
public class RecipeServicesImplementDao implements RecipeServicesDao
{
     @Inject
     private RecipeRepositoryDao recipeRepositoryDao;
     @Inject
     private FoodRecipeRepositoryDao foodRecipeRepositoryDao;
     @Inject
     private MacronutrientsRepositoryDao macronutrientsRepositoryDao;


     /**
      * <h1>getRecipe</h1>
      * <p>Obtiene un objeto Recipe del Repositorio</p>
      *
      * @param id Indetificador que reprecenta el elemeto a buscar.
      */
     @Override
     public void getRecipe(long id)
     {
          this.recipeRepositoryDao.getRecipeDto(id);
     }

     /**
      * <h1>getAllRecipe</h1>
      * <p>Obtiene una lista de la base de todos los objetos relacionados al indentificador</p>
      *
      * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de con todos lo objetos encontrados
      */
     @Override
     public List<RecipeDto> getAllRecipe(long id)
     {
          return this.recipeRepositoryDao.getAllRecipe();
     }

     /**
      * <h1>addRecipe</h1>
      * <p>Envia un objeto al repositorio</p>
      *
      * @param recipeDto Objeto que encapsula los nunevos elemetos.
      */
     @Override
     public void addRecipe(RecipeDto recipeDto)
     {
          recipeDto.setId(this.recipeRepositoryDao.getIncrementID());
          this.recipeRepositoryDao.createRecipe(recipeDto);
     }

     /**
      * <h1>deleteRecipe</h1>
      * <p>Da la orden al repositorio para eliminar el elemto.</p>
      *
      * @param id Indetificador que reprecenta el objeto a eliminar
      */
     @Override
     public void deleteRecipe(long id)
     {
          this.recipeRepositoryDao.deleteRecipe(id);
     }

     /**
      * <h1>updateRecipe</h1>
      * <p>Da la orden al repositorio para actulizar un objeto.</p>
      *
      * @param recipeDto Objeto que encapsula los nuevos datos.
      */
     @Override
     public void updateRecipe(RecipeDto recipeDto)
     {
          this.recipeRepositoryDao.updateRecipe(recipeDto);
     }

     /**
      * <h1>addFoodRecipe</h1>
      * <p>Envia el objeto a repositorio para ser alamacenado</p>
      *
      * @param foodRecipeDto Objeto que encapsula el nuevo elemeto a ser enviado.
      */
     @Override
     public void addFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          foodRecipeDto.setId(this.foodRecipeRepositoryDao.getIncrementID());
          this.foodRecipeRepositoryDao.createFoodRecipe(foodRecipeDto);
     }

     /**
      * <h1>getFoodRecipe</h1>
      * <p>Obtiene un eleemto del repositorio</p>
      *
      * @param id Identificador que reprecenta el elemto a buscar
      */
     @Override
     public FoodRecipeDto getFoodRecipe(long id)
     {
          return this.foodRecipeRepositoryDao.getFoodRecipe(id);
     }

     /**
      * <h1>getAllFoodRecipe</h1>
      * <p>Obtiene una lista relacionado al identificador que se le pasa como parametro</p>
      *
      * @param id Identificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de los objetos encontrados
      */
     @Override
     public List<FoodRecipeDto> getAllFoodRecipe(long id)
     {
          return this.foodRecipeRepositoryDao.getAllFoodRecipe(id);
     }

     /**
      * <h1>updateFoodRecipe</h1>
      * <p>Da la orden para actualizar un nuevo elemeto en la base de datos</p>
      *
      * @param foodRecipeDto Objeto que encapsula los nuevos elementos de la base de datos
      */
     @Override
     public void updateFoodRecipe(FoodRecipeDto foodRecipeDto)
     {
          this.foodRecipeRepositoryDao.updateFoodRecipe(foodRecipeDto);
     }

     /**
      * <h1>deleteFoodRecipe</h1>
      * <p>Da la order al repositorio de eliminar un elemeto.</p>
      *
      * @param id Identificar que reprecenta el objeto a eliminar
      */
     @Override
     public void deleteFoodRecipe(long id)
     {
          this.foodRecipeRepositoryDao.deleteFoodRecipe(id);
     }

     /**
      * <h1>addMacros</h1>
      * <p>Agrega un elemento a la base de datos </p>
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
