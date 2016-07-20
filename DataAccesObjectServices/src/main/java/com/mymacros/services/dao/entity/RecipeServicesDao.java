package com.mymacros.services.dao.entity;

import com.mymacros.dto.entity.FoodRecipeDto;
import com.mymacros.dto.entity.MacronutrientsDto;
import com.mymacros.dto.entity.RecipeDto;

import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
public interface RecipeServicesDao
{
     /**
      * =================================================>Recipe
      */
     /**
      * <h1>getRecipe</h1>
      * <p>Obtiene un objeto Recipe del Repositorio</p>
      * @param id Indetificador que reprecenta el elemeto a buscar.
      */
     void getRecipe(long id);

     /**
      * <h1>getAllRecipe</h1>
      * <p>Obtiene una lista de la base de todos los objetos relacionados al indentificador</p>
      * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de con todos lo objetos encontrados
      */
     List<RecipeDto> getAllRecipe(long id);

     /**
      * <h1>addRecipe</h1>
      * <p>Envia un objeto al repositorio</p>
      * @param recipeDto Objeto que encapsula los nunevos elemetos.
      */
     void addRecipe(RecipeDto recipeDto);

     /**
      * <h1>deleteRecipe</h1>
      * <p>Da la orden al repositorio para eliminar el elemto.</p>
      * @param id Indetificador que reprecenta el objeto a eliminar
      */
     void deleteRecipe(long id);

     /**
      * <h1>updateRecipe</h1>
      * <p>Da la orden al repositorio para actulizar un objeto.</p>
      * @param recipeDto Objeto que encapsula los nuevos datos.
      */
     void updateRecipe(RecipeDto recipeDto);
     /**
      * ====================================================>FoodRecipe
      */
     /**
      * <h1>addFoodRecipe</h1>
      * <p>Envia el objeto a repositorio para ser alamacenado</p>
      *
      * @param foodRecipeDto Objeto que encapsula el nuevo elemeto a ser enviado.
      */
     void addFoodRecipe(FoodRecipeDto foodRecipeDto);

     /**
      * <h1>getFoodRecipe</h1>
      * <p>Obtiene un eleemto del repositorio</p>
      * @param id Identificador que reprecenta el elemto a buscar
      */
     FoodRecipeDto getFoodRecipe(long id);

     /**
      * <h1>getAllFoodRecipe</h1>
      * <p>Obtiene una lista relacionado al identificador que se le pasa como parametro</p>
      * @param id Identificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de los objetos encontrados
      */
     List<FoodRecipeDto> getAllFoodRecipe(long id);

     /**
      * <h1>updateFoodRecipe</h1>
      * <p>Da la orden para actualizar un nuevo elemeto en la base de datos</p>
      * @param foodRecipeDto Objeto que encapsula los nuevos elementos de la base de datos
      */
     void updateFoodRecipe(FoodRecipeDto foodRecipeDto);

     /**
      * <h1>deleteFoodRecipe</h1>
      * <p>Da la order al repositorio de eliminar un elemeto.</p>
      * @param id Identificar que reprecenta el objeto a eliminar
      */
     void deleteFoodRecipe(long id);
     /**
      * =====================================================>Macros
      */
     /**
      * <h1>addMacros</h1>
      * <p>Agrega un elemento a la base de datos </p>
      * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
      */
     void addMacros(MacronutrientsDto macronutrientsDto);

     /**
      * <h1>getMacros</h1>
      * <p>Obtiene un objeto a partir de su indetificador que lo relaciona</p>
      * @param id Indetificador que reprecenta la relacion del objeto a quien lo esta llamado
      * @return Retorna el objeto que se encuentra relacionad
      */
     MacronutrientsDto getMacros(long id);

     /**
      * <h1>getAllMactos</h1>
      * <p>Obtiene una lista de elementos apartir del indetificador que los relaciona</p>
      * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
      * @return Retorna una lista de elemetos.
      */
     List<MacronutrientsDto> getAllMacros(long id);

     /**
      * <h1>updateMactos</h1>
      * <p>Actualiza un elemto de la base de datos</p>
      * @param foodRecipeDto Objeto que encapsula los nuevos elemetos
      */
     void updateMacros(MacronutrientsDto foodRecipeDto);

     /**
      * <h1>deleteMacros</h1>
      * <p>Da la orden al repositorio para eliminar un objeto</p>
      * @param id Indetificador que reprecenta el obejto a eliminar.
      */
     void deleteMacros(long id);
}
