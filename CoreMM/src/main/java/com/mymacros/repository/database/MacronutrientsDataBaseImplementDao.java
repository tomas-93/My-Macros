package com.mymacros.repository.database;

import com.mymacros.dao.entity.MacronutrientsDao;
import com.mymacros.dto.entity.MacronutrientsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomas on 18/07/2016.
 */
@Repository
public class MacronutrientsDataBaseImplementDao implements MacronutrientsDao
{
     private final Map<Long, MacronutrientsDto> macronutrientsDtoDataBase = new Hashtable<Long, MacronutrientsDto>();
     private volatile long idMacros = 1L;

     @Override
     public synchronized List<MacronutrientsDto> getAllMacronutrients()
     {
          List<MacronutrientsDto> list = new ArrayList<MacronutrientsDto>();
          for(Long id: this.macronutrientsDtoDataBase.keySet())
               list.add(this.macronutrientsDtoDataBase.get(id));

          return list;
     }

     @Override
     public MacronutrientsDto getMacronutrients(long id)
     {
          return this.macronutrientsDtoDataBase.get(id);
     }

     @Override
     public void createMacronutrients(MacronutrientsDto macronutrientsDto)
     {
          if (!this.macronutrientsDtoDataBase.isEmpty())
               this.idMacros++;
          macronutrientsDto.setId(this.idMacros);
          this.macronutrientsDtoDataBase.put(macronutrientsDto.getId(), macronutrientsDto);
     }

     @Override
     public void updateMacronutrients(MacronutrientsDto macronutrientsDto)
     {
          this.macronutrientsDtoDataBase.put(macronutrientsDto.getId(), macronutrientsDto);
     }

     @Override
     public void deleteMacronutrients(long id)
     {
          this.macronutrientsDtoDataBase.remove(id);
     }
}
