package com.mymacros.repository.dao.database;

import com.mymacros.repository.dao.entity.RecipeEntity;
import com.mymacros.repository.dao.entity.RecipeRepositoryDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class RecipeDataBaseImplementDao implements RecipeRepositoryDao
{
    @Inject
    private Session session;
    /**
     * <h1>getAllRecipe</h1>
     * <p>Obtiene una lista de los elemento de la base de datos</p>
     *
     * @return Lista de todos los objetos de la base de datos
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<RecipeEntity> getAllRecipe(long idUser)
    {
        return (List<RecipeEntity>)
                this.session.createQuery("from RecipeEntity inner join UserEntity " +
                        "where RecipeEntity.userByIdUser =:idUser")
                .setParameter("idUser", idUser)
                .list();

    }

    /**
     * <h1>getRecipeDto</h1>
     * <p>Obtiene un elemento de la base de datos</p>
     *
     * @param id Indetificador del objeto a obtener de la base de datos
     * @return Retorna el objeto encotrnado en la base de datos
     */
    @Override
    public RecipeEntity getRecipeDto(long id)
    {
        return this.session.load(RecipeEntity.class, id);
    }

    /**
     * <h1>createRecipe</h1>
     * <p>Agrega un nuevo elemento a la base de datos</p>
     *
     * @param recipeEntity Objeto que encapsula la informacion para alamcenar.
     */
    @Override
    public void createRecipe(RecipeEntity recipeEntity)
    {
        this.session.save(recipeEntity);
    }

    /**
     * <h1>updateRecipe</h1>
     * <p>Actualiza un nuevo elemto de la base de datos</p>
     *
     * @param recipeEntity Objeto que tiene los datos actualizados.
     */
    @Override
    public void updateRecipe(RecipeEntity recipeEntity)
    {
        if (this.session.load(RecipeEntity.class, recipeEntity.getId()) != null)
            this.session.update(recipeEntity);
    }

    /**
     * <h1>deleteRecipe</h1>
     * <p>Elimina una receta de la base de datos, de igual forma que sus alimentos y su macros</p>
     *
     * @param id Indetificador que especifica elemeto a eliminar.
     */
    @Override
    public void deleteRecipe(long id)
    {
        if (this.session.load(RecipeEntity.class, id) != null)
            this.session.remove(id);
    }
}
