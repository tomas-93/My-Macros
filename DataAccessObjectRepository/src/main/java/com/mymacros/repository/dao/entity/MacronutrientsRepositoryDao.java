package com.mymacros.repository.dao.entity;

import com.mymacros.database.entity.MacrosEntity;

import java.util.List;

/**
 * Created by Tomas on 17/07/2016.
 */
public interface MacronutrientsRepositoryDao
{
     List<MacrosEntity> getAllMacronutrients(long id);
     MacrosEntity getMacronutrients(long id);
     void createMacronutrients(MacrosEntity macronutrientsDto);
     void updateMacronutrients(MacrosEntity macronutrientsDto);
     void deleteMacronutrients(long id);
}
