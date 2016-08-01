package com.mymacros.repository.dao.database;


import com.mymacros.repository.dao.entity.FoodRecipeRepositoryDao;
import com.mymacros.repository.dao.entity.FoodRecipeEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class FoodRecipeDataBaseImplementDao implements FoodRecipeRepositoryDao
{
    @Inject
    private Session session;

    /**
     * <h1>getAllFoodRecipe</h1>
     * <p>Obtiene una lista de la base de datos</p>
     *
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<FoodRecipeEntity> getAllFoodRecipe(long idRecipe)
    {
        return (List<FoodRecipeEntity>)
                this.session.createQuery("from FoodRecipeEntity inner join  RecipeEntity where  FoodRecipeEntity.recipeByIdRecipe=:idRecipe")
                        .setParameter("idRecipe", idRecipe)
                        .list();
    }

    /**
     * <h1>getFoodRecipe</h1>
     * <p>Obtiene un elemento de la base de datos especificado por el id</p>
     *
     * @param id Identificador que reprecenta el valor del objeto a buscar
     * @return retorna el objeto encontrado de la base de datos.
     */
    @Override
    public FoodRecipeEntity getFoodRecipe(long id)
    {
        return this.session.load(FoodRecipeEntity.class, id);
    }

    /**
     * <h1>createFoodRrecipe</h1>
     * <p>Agrega un nuevo elemto a la base de datos</p>
     *
     * @param foodRecipeDto elemeto que se agregara a la base de datos
     */
    @Override
    public void createFoodRecipe(FoodRecipeEntity foodRecipeDto)
    {
        this.session.save(foodRecipeDto);
    }

    /**
     * <h1>updateFoodRecipe</h1>
     * <p>Actualiza un elemto en la base de datos</p>
     *
     * @param foodRecipeDto objeto que encapsula el objeto a editar
     */
    @Override
    public void updateFoodRecipe(FoodRecipeEntity foodRecipeDto)
    {
        if (this.session.load(FoodRecipeEntity.class, foodRecipeDto.getId()) != null)
            this.session.update(foodRecipeDto);
    }

    /**
     * <h1>deleteFoodRecipe</h1>
     * <p>Elomina un elemto de la base de datos</p>
     *
     * @param id indetificador de la base de datos que representa el elemto a eliminar
     */
    @Override
    public void deleteFoodRecipe(long id)
    {
        if (this.session.load(FoodRecipeEntity.class, id) != null)
            this.session.remove(id);
    }


}
