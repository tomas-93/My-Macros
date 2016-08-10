package com.mymacros.web.controller;

import com.mymacros.dto.entity.ProfileDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.UserAndProfileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * @author Tomas Yussef Galicia Guzman
 */
@Controller
@RequestMapping(value = "/app/profile")
public class ProfileController
{
    @Inject
    private UserAndProfileService userAndProfileService;
    public final Logger messge = LogManager.getLogger();

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getListProfile(Map<String, Object> model, HttpSession session)
    {
        UserDto userDto = UserController.getSession(session);
        List<ProfileDto> list = this.userAndProfileService.getAllProfile(userDto.getId());
        if (list == null)
            return "redirect:add";

        model.put("listProfile", list);
        return "profile/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddPage(Map<String, Object> model)
    {
        model.put("profileDto", new ProfileDto());
        return "profile/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProfile(HttpSession session,
                             @Valid @ModelAttribute("profileDto")
                                     ProfileDto profileDto,
                             BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "profile/add";

        UserDto userDto = UserController.getSession(session);
        profileDto.setUserDto(userDto);
        this.userAndProfileService.addProfile(profileDto);
        return "redirect:list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEditPage(@PathVariable("id") Long id,
                              Map<String, Object> model)
    {
        ProfileDto profileDto = this.userAndProfileService.getProfile(id);
        model.put("profileDto", profileDto);
        return "profile/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editProfile(@Valid @ModelAttribute("profileDto")
                                      ProfileDto profileDto,
                              BindingResult bindingResult, HttpSession session)
    {
        if (bindingResult.hasErrors())
            return "profile/edit";
        UserDto userDto = UserController.getSession(session);
        profileDto.setUserDto(userDto);
        this.userAndProfileService.updateProfile(profileDto);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public String removeProfile(@PathVariable("id") Long id)
    {
        this.userAndProfileService.deleteProfile(id);
        return "redirect:profile/list";
    }

}
