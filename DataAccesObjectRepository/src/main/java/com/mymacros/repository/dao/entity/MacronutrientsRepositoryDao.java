package com.mymacros.repository.dao.entity;

import com.mymacros.dto.entity.MacronutrientsDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface MacronutrientsRepositoryDao extends IDBase
{
     List<MacronutrientsDto> getAllMacronutrients(long id);
     MacronutrientsDto getMacronutrients(long id);
     void createMacronutrients(MacronutrientsDto macronutrientsDto);
     void updateMacronutrients(MacronutrientsDto macronutrientsDto);
     void deleteMacronutrients(long id);
}
