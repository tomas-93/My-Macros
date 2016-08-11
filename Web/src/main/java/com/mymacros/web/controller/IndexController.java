package com.mymacros.web.controller;

import com.mymacros.services.dao.entity.UserAndProfileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Tomas Yussef Galicia Guzman.
 */
@Controller
public class IndexController
{
    private final Logger message = LogManager.getLogger();

    @Inject
    private UserAndProfileService userAndProfileServiceDao;

    @RequestMapping("/")
    public View getIdenx(Map<String, Object> modelMap, HttpSession session)
    {
        return new RedirectView("/app/daily/list");
    }
}
