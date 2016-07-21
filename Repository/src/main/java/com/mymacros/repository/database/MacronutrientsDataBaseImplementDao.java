package com.mymacros.repository.database;

import com.mymacros.repository.dao.entity.MacronutrientsRepositoryDao;
import com.mymacros.dto.entity.MacronutrientsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 *
 */
@Repository
public class MacronutrientsDataBaseImplementDao implements MacronutrientsRepositoryDao
{
     private final Map<Long, MacronutrientsDto> macronutrientsDtoDataBase = new Hashtable<>();
     private volatile long idMacros = 1L;

     /**
      * <h1>getAllMacronutrients</h1>
      * <p>Obtiene una lista de todos los elemtos de la base de datos</p>
      * @return Retorna una lista de una base de datos
      */
     @Override
     public List<MacronutrientsDto> getAllMacronutrients(long idMacros)
     {
          List<MacronutrientsDto> list = new ArrayList<MacronutrientsDto>();
          for(Long id: this.macronutrientsDtoDataBase.keySet())
               list.add(this.macronutrientsDtoDataBase.get(id));

          return list;
     }

     /**
      * <h1>getMacronutrients</h1>
      * <p>Se obtiene un objeto MacronutrientsDto</p>
      * @param id Identificador que reprecenta el valor a busca en la base de datos
      * @return Retorna el objeto de la base de datos.
      */
     @Override
     public MacronutrientsDto getMacronutrients(long id)
     {
          return this.macronutrientsDtoDataBase.get(id);
     }

     /**
      * <h1>createMacronutrients</h1>
      * <p>Elemto que agrega un elemto a la base detos</p>
      * @param macronutrientsDto Objeto que agrega un nuevo elemento a la base de datos
      */
     @Override
     public void createMacronutrients(MacronutrientsDto macronutrientsDto)
     {
          this.macronutrientsDtoDataBase.put(macronutrientsDto.getId(), macronutrientsDto);
     }

     /**
      * <h1>updateMacronutrients</h1>
      * <p>Actualiza un nuevo elemeto de la base de datos</p>
      * @param macronutrientsDto Objeto que encapsula los elemtos actualizados
      */
     @Override
     public  void updateMacronutrients(MacronutrientsDto macronutrientsDto)
     {
          this.macronutrientsDtoDataBase.put(macronutrientsDto.getId(), macronutrientsDto);
     }

     /**
      * <h1>deleteMacronutrients</h1>
      * <p>Elimina un elemeto en la base de datos</p>
      * @param id Identificador que especifica el elemto a eliminar.
      */
     @Override
     public void deleteMacronutrients(long id)
     {
          this.macronutrientsDtoDataBase.remove(id);
     }

     @Override
     public synchronized long getIncrementID()
     {
          return 0;
     }
}
