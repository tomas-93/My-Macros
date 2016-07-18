package com.mymacros.dao;

import com.mymacros.dto.entity.MacronutrientsDto;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface MacronutrientsDao
{
     List<MacronutrientsDto> getAllMacronutrients();
     MacronutrientsDto getMacronutrients(long id);
     void createMacronutrients(MacronutrientsDto macronutrientsDto);
     void deleteMacronutrients(long id);
}
