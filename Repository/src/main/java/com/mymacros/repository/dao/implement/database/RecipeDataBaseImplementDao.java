package com.mymacros.repository.dao.implement.database;

import com.mymacros.database.entity.RecipeEntity;
import com.mymacros.repository.dao.entity.RecipeRepositoryDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;



/**
 * @author Tomas Yussef Galicia Guzman
 */
@Repository
public class RecipeDataBaseImplementDao extends HibernateTemplate implements RecipeRepositoryDao
{
    @Inject
    public RecipeDataBaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
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
                this.find("from RecipeEntity inner join UserEntity " +
                        "where RecipeEntity.userByIdUser =:idUser", idUser);
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
        return this.load(RecipeEntity.class, id);
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
        this.save(recipeEntity);
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
        if (this.load(RecipeEntity.class, recipeEntity.getId()) != null)
            this.update(recipeEntity);
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
        RecipeEntity recipeEntity = this.load(RecipeEntity.class, id);
        if (recipeEntity != null)
            this.delete(recipeEntity);
    }
}
