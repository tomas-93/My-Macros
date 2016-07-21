package com.mymacros.repository.database;

import com.mymacros.repository.dao.entity.FoodRecipeRepositoryDao;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.repository.dao.entity.RecipeRepositoryDao;
import com.mymacros.dto.entity.RecipeDto;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class RecipeDataBaseImplementDao implements RecipeRepositoryDao {
     private final Map<Long, RecipeDto> recipeDtoDatabase = new Hashtable<>();
     private volatile long idRecipe = 1L;
     @Inject
     private MacronutrientsRepositoryDao macronutrientsDao;
     @Inject
     private FoodRecipeRepositoryDao foodRecipeDao;

     /**
      * <h1>getAllRecipe</h1>
      * <p>Obtiene una lista de los elemento de la base de datos</p>
      *
      * @return Lista de todos los objetos de la base de datos
      */
     @Override
     public List<RecipeDto> getAllRecipe(long idUser)
     {
          return this.recipeDtoDatabase.keySet()
                  .stream()
                  .map(this.recipeDtoDatabase::get)
                  .filter(recipeDto -> recipeDto.getId()==idUser)
                  .collect(Collectors.toList());
     }

     /**
      * <h1>getRecipeDto</h1>
      * <p>Obtiene un elemento de la base de datos</p>
      *
      * @param id Indetificador del objeto a obtener de la base de datos
      * @return Retorna el objeto encotrnado en la base de datos
      */
     @Override
     public RecipeDto getRecipeDto(long id) {
          return this.recipeDtoDatabase.get(id);
     }

     /**
      * <h1>createRecipe</h1>
      * <p>Agrega un nuevo elemento a la base de datos</p>
      *
      * @param recipeDto Objeto que encapsula la informacion para alamcenar.
      */
     @Override
     public void createRecipe(RecipeDto recipeDto) {
          this.recipeDtoDatabase.put(recipeDto.getId(), recipeDto);
     }

     /**
      * <h1>updateRecipe</h1>
      * <p>Actualiza un nuevo elemto de la base de datos</p>
      *
      * @param recipeDto Objeto que tiene los datos actualizados.
      */
     @Override
     public void updateRecipe(RecipeDto recipeDto) {
          this.recipeDtoDatabase.replace(recipeDto.getId(), recipeDto);
     }

     /**
      * <h1>deleteRecipe</h1>
      * <p>Elimina una receta de la base de datos, de igual forma que sus alimentos y su macros</p>
      *
      * @param id Indetificador que especifica elemeto a eliminar.
      */
     @Override
     public void deleteRecipe(long id) {
          final long idMacros = this.recipeDtoDatabase.get(id).getIdMacros();
          final long idFoodRecipe = this.recipeDtoDatabase.get(id).getIdFoodRecipe();
          this.foodRecipeDao.deleteFoodRecipe(idFoodRecipe);
          this.macronutrientsDao.deleteMacronutrients(idMacros);
          this.recipeDtoDatabase.remove(id);
     }

     @Override
     public synchronized long getIncrementID() {
          return this.idRecipe++;
     }
}
