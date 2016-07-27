package com.mymacros.web.controller;

import com.mymacros.dto.entity.DailyDto;
import com.mymacros.dto.entity.FoodDailyDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Tomas on 24/07/2016.
 */
@Controller
@RequestMapping("/app/daily")
public class DailyController
{
     /**
      *
      * @return
      */
     @RequestMapping(value = "/list", method = RequestMethod.GET)
     public String getDaily(Model model,
                            HttpServletRequest request,
                            @RequestParam(value = "message", defaultValue = "false", required = false) boolean message)
     {
          model.addAttribute("idUser",request.getSession().getAttribute("idUser"));
          if (message)
               model.addAttribute("message", 0);

          List<DailyDto> dailyDtoList;
          List<FoodDailyDto> foodDailyDtoList;

          return "daily/list";
     }



}
