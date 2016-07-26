package com.mymacros.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Tomas on 23/07/2016.
 */
@Controller
public class IndexController
{
     @RequestMapping(value = {"/daily/*", "/food/*", "/profile/*"})
     public void getIndex(HttpServletRequest request, HttpServletResponse response) throws IOException
     {
          if (request.getSession().getAttribute("idUser") == null)
               response.sendRedirect("/user/login");
     }
     @RequestMapping("/")
     public View getIdenx()
     {
          return new RedirectView("user/login");
     }

}
