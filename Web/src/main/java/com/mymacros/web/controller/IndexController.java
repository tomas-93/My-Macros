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
     @RequestMapping("/")
     public View getIdenx()
     {
          return new RedirectView("/app/daily/list");
     }
}
