package com.mymacros.services;


import com.mymacros.database.entity.FoodRecipeEntity;
import com.mymacros.database.entity.RecipeEntity;
import com.mymacros.dto.entity.FoodRecipeDto;
import com.mymacros.dto.entity.MacronutrientsDto;
import com.mymacros.dto.entity.RecipeDto;
import com.mymacros.repository.dao.entity.FoodRecipeRepositoryDao;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.repository.dao.entity.RecipeRepositoryDao;
import com.mymacros.services.dao.entity.RecipeServicesDao;
import com.mymacros.services.util.Convert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tomas Yussef Galicia Guzman
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
    @Transactional
    public RecipeDto getRecipe(long id)
    {
        return Convert.recipeDto(this.recipeRepositoryDao.getRecipeDto(id));
    }

    /**
     * <h1>getAllRecipe</h1>
     * <p>Obtiene una lista de la base de todos los objetos relacionados al indentificador</p>
     *
     * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
     * @return Retorna una lista de con todos lo objetos encontrados
     */
    @Override
    @Transactional
    public List<RecipeDto> getAllRecipe(long id)
    {
        return this.recipeRepositoryDao.getAllRecipe(id)
                .stream()
                .map(Convert::recipeDto)
                .collect(Collectors.toList());
    }

    /**
     * <h1>addRecipe</h1>
     * <p>Envia un objeto al repositorio</p>
     *
     * @param recipeDto Objeto que encapsula los nunevos elemetos.
     */
    @Override
    @Transactional
    public void addRecipe(RecipeDto recipeDto)
    {
        this.recipeRepositoryDao.createRecipe(Convert.recipeEntity(recipeDto));
    }

    /**
     * <h1>deleteRecipe</h1>
     * <p>Da la orden al repositorio para eliminar el elemto.</p>
     *
     * @param id Indetificador que reprecenta el objeto a eliminar
     */
    @Override
    @Transactional
    public void deleteRecipe(long id)
    {
        RecipeEntity recipeEntity = this.recipeRepositoryDao.getRecipeDto(id);
        this.foodRecipeRepositoryDao.getAllFoodRecipe(recipeEntity.getId())
                .stream()
                .map(FoodRecipeEntity::getId)
                .forEach(this.foodRecipeRepositoryDao::deleteFoodRecipe);
        this.deleteMacros(recipeEntity.getMacrosEntity().getId());
    }

    /**
     * <h1>updateRecipe</h1>
     * <p>Da la orden al repositorio para actulizar un objeto.</p>
     *
     * @param recipeDto Objeto que encapsula los nuevos datos.
     */
    @Override
    @Transactional
    public void updateRecipe(RecipeDto recipeDto)
    {
        this.recipeRepositoryDao.updateRecipe(Convert.recipeEntity(recipeDto));
    }

    /**
     * <h1>addFoodRecipe</h1>
     * <p>Envia el objeto a repositorio para ser alamacenado</p>
     *
     * @param foodRecipeDto Objeto que encapsula el nuevo elemeto a ser enviado.
     */
    @Override
    @Transactional
    public void addFoodRecipe(FoodRecipeDto foodRecipeDto)
    {
        this.foodRecipeRepositoryDao.createFoodRecipe(Convert.foodRecipeEntity(foodRecipeDto));
    }

    /**
     * <h1>getFoodRecipe</h1>
     * <p>Obtiene un eleemto del repositorio</p>
     *
     * @param id Identificador que reprecenta el elemto a buscar
     */
    @Override
    @Transactional
    public FoodRecipeDto getFoodRecipe(long id)
    {
        return Convert.foodRecipeDto(this.foodRecipeRepositoryDao.getFoodRecipe(id));
    }

    /**
     * <h1>getAllFoodRecipe</h1>
     * <p>Obtiene una lista relacionado al identificador que se le pasa como parametro</p>
     *
     * @param id Identificador que reprecenta la relacion de los objetos a buscar.
     * @return Retorna una lista de los objetos encontrados
     */
    @Override
    @Transactional
    public List<FoodRecipeDto> getAllFoodRecipe(long id)
    {
        return this.foodRecipeRepositoryDao.getAllFoodRecipe(id)
                .stream()
                .map(Convert::foodRecipeDto)
                .collect(Collectors.toList());
    }

    /**
     * <h1>updateFoodRecipe</h1>
     * <p>Da la orden para actualizar un nuevo elemeto en la base de datos</p>
     *
     * @param foodRecipeDto Objeto que encapsula los nuevos elementos de la base de datos
     */
    @Override
    @Transactional
    public void updateFoodRecipe(FoodRecipeDto foodRecipeDto)
    {
        this.foodRecipeRepositoryDao.updateFoodRecipe(Convert.foodRecipeEntity(foodRecipeDto));
    }

    /**
     * <h1>deleteFoodRecipe</h1>
     * <p>Da la order al repositorio de eliminar un elemeto.</p>
     *
     * @param id Identificar que reprecenta el objeto a eliminar
     */
    @Override
    @Transactional
    public void deleteFoodRecipe(long id)
    {
        this.foodRecipeRepositoryDao.deleteFoodRecipe(id);
    }

    /**
     * <h1>addMacros</h1>
     * <p>Agrega un elemento a la base de datos </p>
     *
     * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
     */
    @Override
    @Transactional
    public void addMacros(MacronutrientsDto macronutrientsDto)
    {
        this.macronutrientsRepositoryDao.createMacronutrients(Convert.macrosEntity(macronutrientsDto));

    }

    /**
     * <h1>getMacros</h1>
     * <p>Obtiene un objeto a partir de su indetificador que lo relaciona</p>
     *
     * @param id Indetificador que reprecenta la relacion del objeto a quien lo esta llamado
     * @return Retorna el objeto que se encuentra relacionad
     */
    @Override
    @Transactional
    public MacronutrientsDto getMacros(long id)
    {
        return Convert.macronutrientsDto(this.macronutrientsRepositoryDao.getMacronutrients(id));
    }

    /**
     * <h1>getAllMactos</h1>
     * <p>Obtiene una lista de elementos apartir del indetificador que los relaciona</p>
     *
     * @param id Indetificador que reprecenta la relacion de los objetos a buscar.
     * @return Retorna una lista de elemetos.
     */
    @Override
    @Transactional
    public List<MacronutrientsDto> getAllMacros(long id)
    {
        return this.macronutrientsRepositoryDao.getAllMacronutrients(id)
                .stream()
                .map(Convert::macronutrientsDto)
                .collect(Collectors.toList());
    }

    /**
     * <h1>updateMactos</h1>
     * <p>Actualiza un elemto de la base de datos</p>
     *
     * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
     */
    @Override
    @Transactional
    public void updateMacros(MacronutrientsDto macronutrientsDto)
    {
        this.macronutrientsRepositoryDao.updateMacronutrients(Convert.macrosEntity(macronutrientsDto));
    }

    /**
     * <h1>deleteMacros</h1>
     * <p>Da la orden al repositorio para eliminar un objeto</p>
     *
     * @param id Indetificador que reprecenta el obejto a eliminar.
     */
    @Override
    @Transactional
    public void deleteMacros(long id)
    {
        this.macronutrientsRepositoryDao.deleteMacronutrients(id);
    }
}
