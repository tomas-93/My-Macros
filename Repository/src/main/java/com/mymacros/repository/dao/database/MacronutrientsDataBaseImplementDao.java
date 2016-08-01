package com.mymacros.repository.dao.database;

import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.repository.dao.entity.MacrosEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class MacronutrientsDataBaseImplementDao implements MacronutrientsRepositoryDao
{
    @Inject
    private Session session;
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
                this.session.createQuery("from MacrosEntity where MacrosEntity.id=:idMacros")
                .setParameter("idMacros", idMacros)
                .list();
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
        return this.session.load(MacrosEntity.class, id);
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
        this.session.save(macronutrientsDto);
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
        if (this.session.load(MacrosEntity.class, macronutrientsDto.getId()) != null)
            this.session.update(macronutrientsDto);
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
        if (this.session.load(MacrosEntity.class, id) != null)
            this.session.remove(id);
    }

}
