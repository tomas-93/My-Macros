package com.mymacros.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Tomas on 23/07/2016.
 */
@Controller
public class IndexController
{
     @RequestMapping("/")
     public String getIndex()
     {
          return "index";
     }

}
