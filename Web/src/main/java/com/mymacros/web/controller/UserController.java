package com.mymacros.web.controller;

import com.mymacros.dto.entity.LoginDto;
import com.mymacros.dto.entity.UserAndProfileFormDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.UserAndProfileServiceDao;
import com.mymacros.web.config.RootContextConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

     /**
      *
      * @param model
      * @return
      */
     @RequestMapping(value = "login", method = RequestMethod.GET)
     public String getLogin(Model model)
     {
          RootContextConfig.log.info("Url: user/login Action:getLogin ");
          model.addAttribute("loginDto", new LoginDto());
          return "user/login";
     }

     /**
      *
      * @param loginDto
      * @param bindingResult
      * @param model
      * @return
      */
     @RequestMapping(value = "session", method = RequestMethod.POST)
     public String session(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
                           BindingResult bindingResult, Model model)
     {
          if (bindingResult.hasErrors())
          {
               model.addAttribute("loginDto", loginDto);
               return "user/login";
          }
          return "redirect:list";
     }

     /**
      *
      * @param model
      * @return
      */
     @RequestMapping(value = "add", method = RequestMethod.GET)
     public String addUser(Model model)
     {
          model.addAttribute("userAndProfileFormDto", new UserAndProfileFormDto());
          model.addAttribute("editUser", 0);
          return "user/add";
     }

     /**
      *
      * @param userAndProfileFormDto
      * @param bindingResult
      * @param model
      * @return
      */
     @RequestMapping(value = "add", method = RequestMethod.POST)
     public String addUser(@Valid @ModelAttribute("userAndProfileFormDto")
                                        UserAndProfileFormDto userAndProfileFormDto,
                           BindingResult bindingResult, Model model)
     {
          if (!bindingResult.hasErrors())
          {
               model.addAttribute("userAndProfileFormDto", userAndProfileFormDto);
               return "user/add";
          }
          //TODO Agregar usuario
          return "redirect:list";
     }
     /**
      *
      * @param model
      * @return
      */
     @RequestMapping(value = "edit", method = RequestMethod.GET)
     public String editUser(Model model)
     {
          model.addAttribute("userDto", new UserDto());
          model.addAttribute("editUser", 1);
          return "user/edit";
     }

     /**
      *
      * @param userDto
      * @param bindingResult
      * @return
      */
     @RequestMapping(value = "edit", method = RequestMethod.POST)
     public String editUser(@Valid @ModelAttribute("userDto")UserDto userDto,
                          BindingResult bindingResult, Model model)
     {
          return "user/edit";
     }

     /**
      *
      * @param model
      * @param id
      * @return
      */
     @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
     public String getView(Model model, @PathVariable("id") long id)
     {
          //TODO se codigo donde se obtiene el elemeto
          UserDto userDto = new UserDto();
          userDto.setName("Tomas");
          userDto.setSurname("Yussef");
          userDto.setHeight("170");
          userDto.setWidth("80");
          userDto.setEmail("tomas@yussef");
          model.addAttribute("userDto", userDto);
          return "user/view";

     }

     /**
      * <<-->>
      * @return
      */
     @RequestMapping(value = "list", method = RequestMethod.GET)
     public ModelAndView getDailyList()
     {
          return new ModelAndView("daily/list");
     }


}
