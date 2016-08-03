package com.mymacros.services.util;


import com.mymacros.database.entity.*;
import com.mymacros.dto.entity.*;

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

    /**
     *
     * @param macrosEntity
     * @return
     */
    public static MacronutrientsDto macronutrientsDto(MacrosEntity macrosEntity)
    {
        MacronutrientsDto macronutrientsDto = new MacronutrientsDto();
        macronutrientsDto.setId(macrosEntity.getId());
        macronutrientsDto.setTotalProtein(macrosEntity.getProtein());
        macronutrientsDto.setFiber(macrosEntity.getFiber());
        macronutrientsDto.setSugar(macrosEntity.getSugar());
        macronutrientsDto.setTotalCarbohydrates(macrosEntity.getCarbs());
        macronutrientsDto.setTotalFats(macrosEntity.getFat());
        macronutrientsDto.setMonounsaturated(macrosEntity.getMonounsaturated());
        macronutrientsDto.setPolyunsaturated(macrosEntity.getPolyunsaturated());
        macronutrientsDto.setSaturated(macrosEntity.getSaturated());
        return macronutrientsDto;

    }

    /**
     *
     * @param macronutrientsDto
     * @return
     */
    public static MacrosEntity macrosEntity(MacronutrientsDto macronutrientsDto)
    {
        MacrosEntity macrosEntity = new MacrosEntity();
        macrosEntity.setId(macronutrientsDto.getId());
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

    /**
     *
     * @param recipeDto
     * @return
     */
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

    /**
     *
     * @param recipeEntity
     * @return
     */
    public static RecipeDto recipeDto(RecipeEntity recipeEntity)
    {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipeEntity.getId());
        recipeDto.setName(recipeEntity.getName());
        recipeDto.setIdMacros(recipeEntity.getMacrosEntity().getId());
        recipeDto.setIdUser(recipeEntity.getUserByIdUser().getId());
        return recipeDto;
    }

    /**
     *
     * @param foodRecipeDto
     * @return
     */
    public static FoodRecipeEntity foodRecipeEntity(FoodRecipeDto foodRecipeDto)
    {
        FoodRecipeEntity foodRecipeEntity = new FoodRecipeEntity();
        foodRecipeEntity.setId(foodRecipeDto.getId());

        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(foodRecipeDto.getIdRecipe());
        foodRecipeEntity.setRecipeByIdRecipe(recipeEntity);

        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodRecipeDto.getIdFood());
        foodRecipeEntity.setFoodEntity(foodEntity);



        return foodRecipeEntity;
    }

    /**
     *
     * @param foodRecipeEntity
     * @return
     */
    public static FoodRecipeDto foodRecipeDto(FoodRecipeEntity foodRecipeEntity)
    {
        FoodRecipeDto foodRecipeDto = new FoodRecipeDto();
        foodRecipeDto.setId(foodRecipeEntity.getId());
        foodRecipeDto.setIdFood(foodRecipeEntity.getFoodEntity().getId());
        foodRecipeDto.setIdRecipe(foodRecipeEntity.getRecipeByIdRecipe().getId());
        return foodRecipeDto;
    }
    /**
     *
     * @param dailyDto
     * @return
     */
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

    /**
     *
     * @param dailyEntity
     * @return
     */
    public static DailyDto dailyDto(DailyEntity dailyEntity)
    {
        DailyDto dailyDto = new DailyDto();
        dailyDto.setId(dailyEntity.getId());
        dailyDto.setIdUser(dailyEntity.getUserByIdEntity().getId());
        dailyDto.setIdMacros(dailyEntity.getMacrosEntity().getId());
        dailyDto.setTotalCaloriesConsumed(dailyEntity.getCaloriesConsumed());
        return dailyDto;
    }

    /**
     *
     * @param foodDailyDto
     * @return
     */
    public static DailyFoodEntity foodDailyEntity(FoodDailyDto foodDailyDto)
    {
        DailyFoodEntity dailyFoodEntity = new DailyFoodEntity();
        dailyFoodEntity.setId(foodDailyDto.getId());
        DailyEntity dailyEntity = new DailyEntity();
        dailyEntity.setId(foodDailyDto.getId());
        dailyFoodEntity.setDailyByIdDaily(dailyEntity);
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodDailyDto.getId());
        dailyFoodEntity.setFoodEntity(foodEntity);
        dailyFoodEntity.setNumberFood(foodDailyDto.getNumberFood());
        RecipeEntity recipeEntity = new RecipeEntity();
        recipeEntity.setId(foodDailyDto.getIdRecipe());
        dailyFoodEntity.setRecipeByIdrecipe(recipeEntity);
        return dailyFoodEntity;

    }

    /**
     *
     * @param dailyFoodEntity
     * @return
     */
    public static FoodDailyDto foodDailyDto(DailyFoodEntity dailyFoodEntity)
    {
        FoodDailyDto foodDailyDto = new FoodDailyDto();
        foodDailyDto.setId(dailyFoodEntity.getId());
        foodDailyDto.setIdDaily(dailyFoodEntity.getDailyByIdDaily().getId());
        foodDailyDto.setIdRecipe(dailyFoodEntity.getRecipeByIdrecipe().getId());
        foodDailyDto.setNumberFood(dailyFoodEntity.getNumberFood());
        foodDailyDto.setIdFood(dailyFoodEntity.getFoodEntity().getId());
        return foodDailyDto;
    }

    /**
     *
     * @param userDto
     * @return
     */
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

    /**
     *
     * @param userEntity
     * @return
     */
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

    /**
     *
     * @param profileDto
     * @return
     */
    public static ProfileEntity profileEntity(ProfileDto profileDto)
    {
        MacrosEntity macrosEntity = new MacrosEntity();
        macrosEntity.setCarbs(profileDto.getCarbs());
        macrosEntity.setFat(profileDto.getFat());
        macrosEntity.setFiber(profileDto.getFiber());
        macrosEntity.setProtein(profileDto.getProtein());
        macrosEntity.setTotalCalorie(profileDto.getTotalCalories());
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setMacrosEntity(macrosEntity);
        profileEntity.setName(profileDto.getName());
        return profileEntity;

    }

    /**
     *
     * @param profileEntity
     * @return
     */
    public static ProfileDto profileDto(ProfileEntity profileEntity)
    {
        return new ProfileDto(profileEntity.getId(),
                profileEntity.getUserByIdUser().getId(),
                profileEntity.getMacrosEntity().getCarbs(),
                profileEntity.getMacrosEntity().getFat(),
                profileEntity.getMacrosEntity().getProtein(),
                profileEntity.getMacrosEntity().getFiber(),
                profileEntity.getMacrosEntity().getTotalCalorie(),
                profileEntity.getName());
    }

    /**
     *
     * @param foodEntity
     * @return
     */
    public static FoodDto foodDto(FoodEntity foodEntity)
    {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(foodEntity.getId());
        foodDto.setName(foodEntity.getName());
        foodDto.setBrand(foodEntity.getBrand());
        foodDto.setIdMacronutrients(foodEntity.getMacrosEntity().getId());
        foodDto.setIdUser(foodEntity.getUserByIdUser().getId());
        foodDto.setQuantity(foodEntity.getQuantity());
        foodDto.setType(foodEntity.getType());
        foodDto.setUnit(foodEntity.getUnit());
        return foodDto;
    }

    /**
     *
     * @param foodDto
     * @return
     */
    public static FoodEntity foodEntity(FoodDto foodDto)
    {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setId(foodDto.getId());
        foodEntity.setName(foodDto.getName());
        foodEntity.setBrand(foodDto.getBrand());
        foodEntity.setQuantity(foodDto.getQuantity());
        foodEntity.setUnit(foodDto.getUnit());
        foodEntity.setType(foodDto.getType());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(foodDto.getId());
        foodEntity.setUserByIdUser(userEntity);
        MacrosEntity macrosEntity = new MacrosEntity();
        macrosEntity.setId(foodDto.getId());
        foodEntity.setMacrosEntity(macrosEntity);
        return foodEntity;
    }
}
