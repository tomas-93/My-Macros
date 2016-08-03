package com.mymacros.repository.dao.implement.database;

import com.mymacros.database.entity.MacrosEntity;
import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 *   @author Tomas Yussef Galicia Guzman
 */
@Repository
public class MacronutrientsDataBaseImplementDao extends HibernateTemplate implements MacronutrientsRepositoryDao
{
    @Inject
    public MacronutrientsDataBaseImplementDao(SessionFactory sessionFactory)
    {
        super(sessionFactory);
    }
    /**
     * <h1>getAllMacronutrients</h1>
     * <p>Obtiene una lista de todos los elemtos de la base de datos</p>
     *
     * @return Retorna una lista de una base de datos
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<MacrosEntity> getAllMacronutrients(long idMacros)
    {
        return (List<MacrosEntity>)
                this.find("from MacrosEntity where MacrosEntity.id=:idMacros", idMacros);
    }

    /**
     * <h1>getMacronutrients</h1>
     * <p>Se obtiene un objeto MacronutrientsDto</p>
     *
     * @param id Identificador que reprecenta el valor a busca en la base de datos
     * @return Retorna el objeto de la base de datos.
     */
    @Override
    public MacrosEntity getMacronutrients(long id)
    {
        return this.load(MacrosEntity.class, id);
    }

    /**
     * <h1>createMacronutrients</h1>
     * <p>Elemto que agrega un elemto a la base detos</p>
     *
     * @param macronutrientsDto Objeto que agrega un nuevo elemento a la base de datos
     */
    @Override
    public void createMacronutrients(MacrosEntity macronutrientsDto)
    {
        this.save(macronutrientsDto);
    }

    /**
     * <h1>updateMacronutrients</h1>
     * <p>Actualiza un nuevo elemeto de la base de datos</p>
     *
     * @param macronutrientsDto Objeto que encapsula los elemtos actualizados
     */
    @Override
    public void updateMacronutrients(MacrosEntity macronutrientsDto)
    {
        if (this.load(MacrosEntity.class, macronutrientsDto.getId()) != null)
            this.update(macronutrientsDto);
    }

    /**
     * <h1>deleteMacronutrients</h1>
     * <p>Elimina un elemeto en la base de datos</p>
     *
     * @param id Identificador que especifica el elemto a eliminar.
     */
    @Override
    public void deleteMacronutrients(long id)
    {
        MacrosEntity macrosEntity =this.load(MacrosEntity.class, id);
        if (macrosEntity != null)
            this.delete(id);
    }

}
