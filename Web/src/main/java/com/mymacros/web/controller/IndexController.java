package com.mymacros.web.controller;

import com.mymacros.dto.entity.ProfileDto;
import com.mymacros.dto.entity.UserDto;
import com.mymacros.services.dao.entity.UserAndProfileServiceDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;

/**
 * Created by Tomas on 23/07/2016.
 */
@Controller
public class IndexController
{
     @Inject
     UserAndProfileServiceDao userAndProfileServiceDao;
     @RequestMapping("/")
     public View getIdenx()
     {
          if (userAndProfileServiceDao.getUser(10) != null)
          {
               UserDto userDto = new UserDto();
               userDto.setId(10);
               userDto.setName("Tomas");
               userDto.setSurname("Yussef");
               userDto.setEmail("tomasyussef@gmail.com");
               userDto.setPassword("yussef");
               userDto.setWidth("80");
               userDto.setHeight("1.80");
               ProfileDto profileDto =  new ProfileDto();
               profileDto.setId(10);
               profileDto.setIdUser(10);
               profileDto.setCarbs(10);
               profileDto.setProtein(10);
               profileDto.setFat(10);
               profileDto.setTotalCalories(10);
               profileDto.setFiber(10);
          }
          return new RedirectView("/app/daily/list");
     }
}
