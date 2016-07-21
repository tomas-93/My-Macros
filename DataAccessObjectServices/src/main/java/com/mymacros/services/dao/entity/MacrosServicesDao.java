package com.mymacros.services.dao.entity;

import com.mymacros.dto.entity.MacronutrientsDto;

import java.util.List;

/**
 * Created by Tomas on 20/07/2016.
 */
public interface MacrosServicesDao
{
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
      * @param macronutrientsDto Objeto que encapsula los nuevos elemetos
      */
     void updateMacros(MacronutrientsDto macronutrientsDto);

     /**
      * <h1>deleteMacros</h1>
      * <p>Da la orden al repositorio para eliminar un objeto</p>
      * @param id Indetificador que reprecenta el obejto a eliminar.
      */
     void deleteMacros(long id);
}
