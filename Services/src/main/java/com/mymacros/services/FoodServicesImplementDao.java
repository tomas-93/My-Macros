package com.mymacros.services;

import com.mymacros.database.entity.FoodEntity;
import com.mymacros.dto.entity.FoodDto;
import com.mymacros.dto.entity.MacronutrientsDto;
import com.mymacros.repository.dao.entity.FoodRepositoryDao;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.services.dao.entity.FoodServicesDao;
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
    @Transactional
    public FoodDto getFoodDto(long id)
    {
        return Convert.foodDto(this.foodRepositoryDao.getFood(id));
    }

    /**
     * <h1>addFoodDto</h1>
     * <p>Se agrega un nuevo objeto FoodDto al repositorio</p>
     *
     * @param foodDto Objeto que encapsula la nueva informacion.
     */
    @Override
    @Transactional
    public void addFoodDto(FoodDto foodDto)
    {
        this.foodRepositoryDao.createFood(Convert.foodEntity(foodDto));
    }

    /**
     * <h1>getAllFoodDto</h1>
     * <p>Obtiene una lista de todos lo elemto FoodDto del Repositorio</p>
     *
     * @return retorna un objeto list con todos los elemetos
     */
    @Override
    @Transactional
    public List<FoodDto> getAllFoodDto(long idUser)
    {
        return this.foodRepositoryDao.getAllFood(idUser)
                .stream()
                .map(Convert::foodDto)
                .collect(Collectors.toList());
    }

    /**
     * <h1>updateFoodDto</h1>
     * <p>Actualiza un elemento del repostorio</p>
     *
     * @param foodDto Objeto que encapsula los datos actualizados
     */
    @Override
    @Transactional
    public void updateFoodDto(FoodDto foodDto)
    {
        this.foodRepositoryDao.updateFood(Convert.foodEntity(foodDto));
    }

    /**
     * <h1>deleteFoodDto</h1>
     * <p>Elimina un elemeto del respositorio</p>
     *
     * @param id Identificador que reprecenta el elemento a eliminar.
     */
    @Override
    @Transactional
    public void deleteFoodDto(long id)
    {
        FoodEntity foodEntity = this.foodRepositoryDao.getFood(id);
        this.foodRepositoryDao.deleteFood(foodEntity.getId());
        this.deleteMacros(foodEntity.getMacrosEntity().getId());
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
