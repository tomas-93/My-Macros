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

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.UUID;

/**
 * Created by Tomas on 24/07/2016.
 */

@Controller
@RequestMapping("/user")
public class UserController
{
     @Inject
     private UserAndProfileServiceDao userAndProfileServiceDao;
     /**
      * Obtiene el formulario de login
      * @param model objeto que alamacena los elemeto a enviar a la vista
      * @return retorna la url de la vista.
      */
     @RequestMapping(value = "/login", method = RequestMethod.GET)
     public String getLogin(Model model)
     {
          RootContextConfig.log.info("Url: user/login Action:getLogin ");
          model.addAttribute("loginDto", new LoginDto());
          return "user/login";
     }

     /**
      * Session es el metodo que valida el formulario enviado por el usuario
      * envia los errores obtenidos de las validaciones de las anotaciones de hibernate
      * y identifica si el usuario esta registrado si no, lo redirecciona a la pagina de registro.
      *
      * @param loginDto Almacena los datos del formulario login
      * @param bindingResult Representa las respuestas a los errores encontrados tras la validacion
      * @param model modelo que representa el envio de los atributos de este metod
      * @return retorna url de la vista
      */
     @RequestMapping(value = "/session", method = RequestMethod.POST)
     public String session(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
                           BindingResult bindingResult, Model model, HttpServletRequest request)
     {
          if (bindingResult.hasErrors())
          {
               model.addAttribute("loginDto", loginDto);
               return "user/login";
          }
          if(this.userAndProfileServiceDao.loginUser(loginDto))
          {
               HttpSession session = request.getSession();
               session.setAttribute("id", UUID.fromString(loginDto.getEmail()));
               session.setAttribute("email", loginDto.getEmail());
               request.changeSessionId();
               return "redirect:/daily/list";

          }else
          {
               model.addAttribute("message",1);
               model.addAttribute("editUser", 0);
               return "user/add";
          }

     }

     /**
      * Metodo add que envia els formulario a la vista
      * @param model modelo alamacena el objeto que representa el formulario
      * @return retorna la url del formulario
      */
     @RequestMapping(value = "/add", method = RequestMethod.GET)
     public String addUser(Model model)
     {
          model.addAttribute("userAndProfileFormDto", new UserAndProfileFormDto());
          model.addAttribute("editUser", 0);
          return "user/add";
     }

     /**
      * Agrega un nuevo elemeto al repositorio
      * @param userAndProfileFormDto Representa al formulario.
      * @param bindingResult Representa los errores del formulario obtenidos tras la validacion
      * @param model Contiene almacena los errores obtenidos en la validacion
      * @return retorna la vista daily si no tubo errores pero si encontro retorna la del formulario
      */
     @RequestMapping(value = "/add", method = RequestMethod.POST)
     public String addUser(@Valid @ModelAttribute("userAndProfileFormDto")
                                        UserAndProfileFormDto userAndProfileFormDto,
                           BindingResult bindingResult, Model model)
     {
          if (!bindingResult.hasErrors())
          {
               model.addAttribute("userAndProfileFormDto", userAndProfileFormDto);
               return "user/add";
          }
          this.userAndProfileServiceDao.addUserAndProfile(userAndProfileFormDto);
          return "redirect:/daily/list";
     }
     /**
      * Edita un usuario en espesifico obteniendo el id de su URL
      * @param model  envia los objetos a la vista
      * @return retorna la url del formulario edit
      */
     @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
     public String editUser(Model model, @PathVariable("id") long id)
     {
          UserDto userDto = this.userAndProfileServiceDao.getUser(id);
          model.addAttribute("userDto", userDto);
          model.addAttribute("editUser", 1);
          return "user/edit";
     }

     /**
      * Edit por el metodo post alamacena el usuario obtenido del formulario
      * @param userDto represeta los objetos del formulario
      * @param bindingResult representa los errores en la validacion
      * @return retorna la url.
      */
     @RequestMapping(value = "/edit", method = RequestMethod.POST)
     public String editUser(@Valid @ModelAttribute("userDto")UserDto userDto,
                          BindingResult bindingResult, Model model)
     {
          if (!bindingResult.hasErrors())
          {
               model.addAttribute("userDto", userDto);
               model.addAttribute("editUser", 1);
               return "user/edit";
          }
          this.userAndProfileServiceDao.updateUser(userDto);
          model.addAttribute("message", true);
          return "redirect:/daily/list";
     }

     /**
      * Obtiene un usuario y lo envia a la vista
      * @param model Envia los datos a la vista
      * @param id Identificador que representa el objeto a buscar
      * @return retorna la url de la vista
      */
     @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
     public String getView(Model model, @PathVariable("id") long id)
     {
          UserDto userDto = this.userAndProfileServiceDao.getUser(id);
          model.addAttribute("userDto", userDto);
          return "user/view";
     }

}
