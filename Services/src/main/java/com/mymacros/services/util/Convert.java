package com.mymacros.services.util;


import com.mymacros.database.entity.*;
import com.mymacros.dto.entity.*;
import com.sun.corba.se.impl.orbutil.concurrent.CondVar;

/**
 * Created by Tomas on 01/08/2016.
 */
public class Convert
{
    /**
     *
     *  <=========================================>
     *      Metodos para los servicios
     *  <=========================================>
     *
     */

    public static MacronutrientsDto macronutrientsDto(MacrosEntity macrosEntity)
    {
        MacronutrientsDto macronutrientsDto = new MacronutrientsDto();
        try { macronutrientsDto.setId(macrosEntity.getId()); }
        catch(NullPointerException ignored){}
        try {macronutrientsDto.setTotalProtein(macrosEntity.getProtein());}
        catch (NullPointerException ignored){};
        try {macronutrientsDto.setFiber(macrosEntity.getFiber());}
        catch (NullPointerException ignored){}
        try{ macronutrientsDto.setSugar(macrosEntity.getSugar());}
        catch (NullPointerException ignored){};
        try{ macronutrientsDto.setTotalCarbohydrates(macrosEntity.getCarbs()); }
        catch (NullPointerException ignored){};
        try{ macronutrientsDto.setTotalFats(macrosEntity.getFat());}
        catch (NullPointerException ignored){};
        try{ macronutrientsDto.setMonounsaturated(macrosEntity.getMonounsaturated()); }
        catch (NullPointerException ignored){}
        try { macronutrientsDto.setPolyunsaturated(macrosEntity.getPolyunsaturated());}
        catch (NullPointerException ignored){}
        try { macronutrientsDto.setSaturated(macrosEntity.getSaturated());}
        catch (NullPointerException ignored){}
        try{ macronutrientsDto.setTotalCal(macrosEntity.getTotalCalorie()); }
        catch (NullPointerException ignored){}
        return macronutrientsDto;

    }

    public static MacrosEntity macrosEntity(MacronutrientsDto macronutrientsDto)
    {
        MacrosEntity macrosEntity = new MacrosEntity();
        macrosEntity.setId(macronutrientsDto.getId());
        macrosEntity.setTotalCalorie(macronutrientsDto.getTotalCal());
        macrosEntity.setCarbs(macronutrientsDto.getTotalCarbohydrates());
        macrosEntity.setProtein(macronutrientsDto.getTotalProtein());
        macrosEntity.setFat(macronutrientsDto.getTotalFats());
        macrosEntity.setFiber(macronutrientsDto.getFiber());
        macrosEntity.setSugar(macronutrientsDto.getSugar());
        macrosEntity.setPolyunsaturated(macronutrientsDto.getPolyunsaturated());
        macrosEntity.setMonounsaturated(macronutrientsDto.getMonounsaturated());
        macrosEntity.setSaturated(macronutrientsDto.getSaturated());
        return macrosEntity;

    }

    public static RecipeEntity recipeEntity(RecipeDto recipeDto)
    {
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(recipeDto.getId());
        recipeEntity.setName(recipeDto.getName());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(recipeDto.getIdUser());
        recipeEntity.setUserByIdUser(userEntity);

        MacrosEntity macrosEntity = new MacrosEntity();
        macrosEntity.setId(recipeDto.getIdMacros());
        recipeEntity.setMacrosEntity(macrosEntity);

        return recipeEntity;
    }

    public static RecipeDto recipeDto(RecipeEntity recipeEntity)
    {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipeEntity.getId());
        recipeDto.setName(recipeEntity.getName());
        recipeDto.setMacronutrientsDto(Convert.macronutrientsDto(recipeEntity.getMacrosEntity()));
        recipeDto.setUserDto(Convert.userDto(recipeEntity.getUserByIdUser()));
        return recipeDto;
    }

    public static FoodRecipeEntity foodRecipeEntity(FoodRecipeDto foodRecipeDto)
    {
        FoodRecipeEntity foodRecipeEntity = new FoodRecipeEntity();
        foodRecipeEntity.setId(foodRecipeDto.getId());

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(foodRecipeDto.getRecipeDto().getId());
        foodRecipeEntity.setRecipeByIdRecipe(recipeEntity);

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodRecipeDto.getFoodDto().getId());
        foodRecipeEntity.setFoodEntity(foodEntity);



        return foodRecipeEntity;
    }

    public static FoodRecipeDto foodRecipeDto(FoodRecipeEntity foodRecipeEntity)
    {
        FoodRecipeDto foodRecipeDto = new FoodRecipeDto();
        foodRecipeDto.setId(foodRecipeEntity.getId());

        foodRecipeDto.setFoodDto(Convert.foodDto(foodRecipeEntity.getFoodEntity()));

        foodRecipeDto.setRecipeDto(Convert.recipeDto(foodRecipeEntity.getRecipeByIdRecipe()));
        return foodRecipeDto;
    }

    public static DailyEntity dailyEntity(DailyDto dailyDto)
    {
        DailyEntity dailyEntity = new DailyEntity();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(dailyDto.getId());

        MacrosEntity macrosEntity = new MacrosEntity();
        dailyEntity.setCaloriesConsumed(dailyDto.getTotalCaloriesConsumed());

        dailyEntity.setMacrosEntity(macrosEntity);
        dailyEntity.setUserByIdEntity(userEntity);

        return dailyEntity;
    }

    public static DailyDto dailyDto(DailyEntity dailyEntity)
    {
        DailyDto dailyDto = new DailyDto();
        dailyDto.setId(dailyEntity.getId());
        dailyDto.setUserDto(Convert.userDto(dailyEntity.getUserByIdEntity()));
        dailyDto.setMacronutrientsDto(Convert.macronutrientsDto(dailyEntity.getMacrosEntity()));
        dailyDto.setTotalCaloriesConsumed(dailyEntity.getCaloriesConsumed());
        return dailyDto;
    }

    public static DailyFoodEntity foodDailyEntity(FoodDailyDto foodDailyDto)
    {
        DailyFoodEntity dailyFoodEntity = new DailyFoodEntity();
        dailyFoodEntity.setId(foodDailyDto.getId());

        DailyEntity dailyEntity = new DailyEntity();
        dailyEntity.setId(foodDailyDto.getIdDaily());
        dailyFoodEntity.setDailyByIdDaily(dailyEntity);

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodDailyDto.getIdFood());
        dailyFoodEntity.setFoodEntity(foodEntity);

        dailyFoodEntity.setNumberFood(foodDailyDto.getNumberFood());

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(foodDailyDto.getIdRecipe());
        dailyFoodEntity.setRecipeByIdrecipe(recipeEntity);
        return dailyFoodEntity;

    }

    public static FoodDailyDto foodDailyDto(DailyFoodEntity dailyFoodEntity)
    {
        FoodDailyDto foodDailyDto = new FoodDailyDto();
        foodDailyDto.setId(dailyFoodEntity.getId());
        foodDailyDto.setDailyDto(Convert.dailyDto(dailyFoodEntity.getDailyByIdDaily()));
        foodDailyDto.setRecipeDto(Convert.recipeDto(dailyFoodEntity.getRecipeByIdrecipe()));
        foodDailyDto.setNumberFood(dailyFoodEntity.getNumberFood());
        foodDailyDto.setFoodDto(Convert.foodDto(dailyFoodEntity.getFoodEntity()));
        return foodDailyDto;
    }

    public static UserEntity userEntity(UserDto userDto,byte[] password)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setUserName(userDto.getName());
        userEntity.setSurname(userDto.getSurname());
        userEntity.setHeight(userDto.getHeight());
        userEntity.setWeight(userDto.getWeight());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setBirthday(userDto.getBirthday());
        userEntity.setPassword(password);
        return userEntity;
    }

    public static UserDto userDto(UserEntity userEntity)
    {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setName(userEntity.getUserName());
        userDto.setSurname(userEntity.getSurname());
        userDto.setBirthday(userEntity.getBirthday());
        userDto.setEmail(userEntity.getEmail());
        userDto.setHeight(userEntity.getHeight());
        userDto.setWeight(userEntity.getWeight());
        userDto.setPassword(userEntity.getEmail());
        return userDto;
    }

    public static ProfileEntity profileEntity(ProfileDto profileDto)
    {
        MacrosEntity macrosEntity = new MacrosEntity();
        try{ macrosEntity.setId(profileDto.getMacronutrientsDto().getId()); }
        catch (NullPointerException ignore){}
        macrosEntity.setCarbs(profileDto.getMacronutrientsDto().getTotalCarbohydrates());
        macrosEntity.setFat(profileDto.getMacronutrientsDto().getTotalFats());
        macrosEntity.setFiber(profileDto.getMacronutrientsDto().getFiber());
        macrosEntity.setProtein(profileDto.getMacronutrientsDto().getTotalProtein());
        macrosEntity.setTotalCalorie(profileDto.getMacronutrientsDto().getTotalCal());

        UserEntity userEntity = new UserEntity();
        userEntity.setId(profileDto.getUserDto().getId());

        ProfileEntity profileEntity = new ProfileEntity();
        try{profileEntity.setId(profileDto.getId());}
        catch (NullPointerException ignore){}
        profileEntity.setMacrosEntity(macrosEntity);
        profileEntity.setUserByIdUser(userEntity);

        profileEntity.setName(profileDto.getName());
        return profileEntity;

    }

    public static ProfileDto profileDto(ProfileEntity profileEntity)
    {
        return new ProfileDto(profileEntity.getId(),
                Convert.userDto(profileEntity.getUserByIdUser()),
                Convert.macronutrientsDto(profileEntity.getMacrosEntity()),
                profileEntity.getName());
    }

    public static FoodDto foodDto(FoodEntity foodEntity)
    {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(foodEntity.getId());
        foodDto.setName(foodEntity.getName());
        foodDto.setBrand(foodEntity.getBrand());
        foodDto.setMacronutrientsDto(Convert.macronutrientsDto(foodEntity.getMacrosEntity()));
        foodDto.setUserDto(Convert.userDto(foodEntity.getUserByIdUser()));
        foodDto.setQuantity(foodEntity.getQuantity());
        foodDto.setUnit(foodEntity.getUnit());

        return foodDto;
    }

    public static FoodEntity foodEntity(FoodDto foodDto)
    {
        FoodEntity foodEntity = new FoodEntity();
        try{foodEntity.setId(foodDto.getId());}
        catch (NullPointerException ignored){}
        foodEntity.setName(foodDto.getName());
        foodEntity.setBrand(foodDto.getBrand());
        foodEntity.setQuantity(foodDto.getQuantity());
        foodEntity.setUnit(foodDto.getUnit());
        UserEntity userEntity = new UserEntity();
        try { userEntity.setId(foodDto.getUserDto().getId()); }
        catch (NullPointerException ignored){}
        foodEntity.setUserByIdUser(userEntity);
        foodEntity.setMacrosEntity(Convert.macrosEntity(foodDto.getMacronutrientsDto()));
        return foodEntity;
    }
}
