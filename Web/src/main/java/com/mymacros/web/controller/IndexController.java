package com.mymacros.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by Tomas on 23/07/2016.
 */
@Controller
public class IndexController
{
     @RequestMapping("/")
     public View getIndex()
     {
          return new RedirectView("user/login");
     }

}
