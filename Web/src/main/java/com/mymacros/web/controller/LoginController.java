package com.mymacros.web.controller;

import com.mymacros.dto.entity.LoginDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.database.entity.UserEntity;
import com.mymacros.services.dao.entity.UserAndProfileService;
import com.mymacros.web.config.RootContextConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

/**
 * @author Tomas Yussef Galicia Guzman
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController
{
    private final Logger message = LogManager.getLogger();

    @Inject
    private UserAndProfileService userAndProfileServiceDao;

    /**
     * Obtiene el formulario de login
     *
     * @param model objeto que alamacena los elemeto a enviar a la vista
     * @return retorna la url de la vista.
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String getLogin(Model model, HttpSession session)
    {
        RootContextConfig.message.info("\n\nUrl: /formn\n\n");
        model.addAttribute("loginDto", new LoginDto());
        return "login/session";
    }

    /**
     * Session es el metodo que valida el formulario enviado por el usuario
     * envia los errores obtenidos de las validaciones de las anotaciones de hibernate
     * y identifica si el usuario esta registrado si no, lo redirecciona a la pagina de registro.
     *
     * @param loginDto      Almacena los datos del formulario login
     * @param bindingResult Representa las respuestas a los errores encontrados tras la validacion
     * @param model         modelo que representa el envio de los atributos de este metod
     * @return retorna url de la vista
     */
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public String session(@Valid @ModelAttribute("loginDto") LoginDto loginDto,
                          BindingResult bindingResult, Map<String, Object> model, HttpSession session, HttpServletRequest request)
    {
        if (UserEntity.getPrincipal(session) != null)
        {
            UserEntity userEntity = (UserEntity) UserEntity.getPrincipal(session);
            message.info("\n\n Name: "+userEntity.getName()+"\n\n");
            message.info("\n\n Id: "+userEntity.getId()+"\n\n");

            return "redirect:/app/daily/list";
        }

        if (bindingResult.hasErrors())
        {
            model.put("loginDto", loginDto);
            return "login/session";
        }

        Principal principal ;
        try
        {
            principal =  this.userAndProfileServiceDao.login(loginDto);
        }catch (ConstraintViolationException e )
        {
            loginDto.setPassword("");
            model.put("loginDto", loginDto);
            model.put("loginFail", true);
            return "login/session";
        }
        if(principal == null)
        {
            loginDto.setPassword("");
            model.put("loginFail", true);
            return "login/session";
        }
        UserEntity.setPrincipal(session, principal);
        request.changeSessionId();
        return "redirect:/app/daily/list";


    }

    /**
     * Metodo add que envia els formulario a la vista
     *
     * @param model modelo alamacena el objeto que representa el formulario
     * @return retorna la url del formulario
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model)
    {
        model.addAttribute("userDto", new UserDto());
        return "login/add";
    }

    /**
     * Agrega un nuevo elemeto al repositorio
     *
     * @param userDto Representa al formulario.
     * @param bindingResult         Representa los errores del formulario obtenidos tras la validacion
     * @param model                 Contiene almacena los errores obtenidos en la validacion
     * @return retorna la vista daily si no tubo errores pero si encontro retorna la del formulario
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userDto")UserDto userDto, BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
        {
            model.addAttribute("userDto", userDto);
            return "login/add";
        }

        if (!userDto.getPassword().equals(userDto.getRepeatPassword()))
        {
            model.addAttribute("userDto", userDto);
            model.addAttribute("passErr", 1);
            return "login/add";
        }
        this.userAndProfileServiceDao.addUser(userDto);
        return "redirect:/login/form";
    }
}
