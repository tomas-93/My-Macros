package com.mymacros.web.controller;

import com.mymacros.database.entity.UserEntity;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.UserAndProfileService;
import com.mymacros.services.util.Convert;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author Tomas Yussef Galicia Guzman
 */

@Controller
@RequestMapping(value = "/app/user")
public class UserController
{
    @Inject
    private UserAndProfileService userAndProfileServiceDao;

    /**
     * Edita un usuario en espesifico obteniendo el id de su URL
     *
     * @param model envia los objetos a la vista
     * @return retorna la url del formulario edit
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(Map<String, Object> model, HttpSession session)
    {
        model.put("userDto", UserController.getSession(session));
        return "user/edit";
    }

    /**
     * Edit por el metodo post alamacena el usuario obtenido del formulario
     *
     * @param userDto       represeta los objetos del formulario
     * @param bindingResult representa los errores en la validacion
     * @return retorna la url.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editUser(@Valid @ModelAttribute("userDto") UserDto userDto,
                           BindingResult bindingResult, Model model)
    {
        if (!bindingResult.hasErrors())
        {
            model.addAttribute("userDto", userDto);
            return "user/edit";
        }
        this.userAndProfileServiceDao.updateUser(userDto);
        model.addAttribute("message", true);
        return "redirect:/app/daily/list";
    }

    /**
     * Obtiene un usuario y lo envia a la vista
     *
     * @param model Envia los datos a la vista
     * @return retorna la url de la vista
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getView(Map<String, Object> model, HttpSession session)
    {
        model.put("userDto", UserController.getSession(session));
        return "user/view";
    }

    public static UserDto getSession(HttpSession session)
    {
        UserEntity userEntity = (UserEntity) UserEntity.getPrincipal(session);
        return Convert.userDto(userEntity);
    }

}
