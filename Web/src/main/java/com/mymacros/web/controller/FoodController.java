package com.mymacros.web.controller;

import com.mymacros.dto.entity.FoodDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.FoodServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author Tomas Yussef Galicia Guzman
 */
@Controller
@RequestMapping(value = "/app/food")
public class FoodController
{
    @Inject
    private FoodServices foodServices;
    public final Logger message = LogManager.getLogger();

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListFood(Map<String, Object> model, HttpSession session)
    {
        UserDto userDto = UserController.getSession(session);
        List list = this.foodServices.getAllFoodDto(userDto.getId());
        if (list == null)
            return "redirect:add";
        model.put("foodDtoList", list);
        return "food/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddFood(Map<String, Object> model)
    {

        model.put("foodDto", new FoodDto());
        return "food/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAddFood(@Valid @ModelAttribute("foodDto")
                                          FoodDto foodDto,
                              BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors())
            return "food/add";
        UserDto userDto = UserController.getSession(session);
        foodDto.setUserDto(userDto);

        this.foodServices.addFoodDto(foodDto);

        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditFood(Map<String, Object> model,
                             @PathVariable("id") Long id)
    {
        FoodDto foodDto = this.foodServices.getFoodDto(id);
        model.put("foodDto", foodDto);
        return "food/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String postEditFood(@Valid @ModelAttribute("foodDto")
                                           FoodDto foodDto,
                               BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors())
            return "food/edit";
        UserDto userDto = UserController.getSession(session);
        foodDto.setUserDto(userDto);
        this.foodServices.updateFoodDto(foodDto);

        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String getRemoveFood(@PathVariable("id") Long id)
    {
        this.foodServices.deleteFoodDto(id);
        return "redirect:/app/food/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String getViewFood(@PathVariable("id") Long id,
                              Map<String, Object> model)
    {
        FoodDto foodDto = this.foodServices.getFoodDto(id);
        model.put("foodDto", foodDto);
        return "food/view";
    }
}
