package com.mymacros.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Tomas on 24/07/2016.
 */
@Controller
@RequestMapping("daily")
public class DailyController
{
     @RequestMapping(value = "list", method = RequestMethod.GET)
     public String getDaily()
     {
          return "daily/list";
     }
}
