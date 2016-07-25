package com.mymacros.web.controller;

import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.UserAndProfileServiceDao;
import com.mymacros.web.config.RootContextConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * Created by Tomas on 24/07/2016.
 */

@Controller
@RequestMapping("user")
public class UserController
{
     @Inject
     private UserAndProfileServiceDao userAndProfileServiceDao;

     @RequestMapping(value = "login", method = RequestMethod.GET)
     public String getLogin(Model model)
     {
          RootContextConfig.log.info("Url: user/login Action:getLogin ");
          model.addAttribute("userDto", new UserDto());
          return "user/login";
     }
     @RequestMapping(value = "session", method = RequestMethod.POST)
     public String session(Model model,
                           @Valid @ModelAttribute("userDto") UserDto userDto,
                           BindingResult bindingResult)
     {
          if (!bindingResult.hasErrors())
          {
               model.addAttribute("userDto", userDto);
               return "user/login";
          }
          return new RedirectView("daily/list").getUrl();
     }
}
