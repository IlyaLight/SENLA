package com.senla.web.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.service.IPersonService;
import com.senla.web.controller.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static final String TOKEN = "token";

    @Autowired
    IPersonService personService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @PostMapping
    //   @RequestMapping( method = RequestMethod.POST)//, consumes="application/json")
    public void login(@RequestBody Login login , HttpServletResponse res) {
        LOGGER.info("login_GET");
        try {
            String token = TokenUtil.getToken(personService.getPersonBuLogin(login));
            res.addCookie(new Cookie(TOKEN, token));
        } catch (ObjectAvailabilityException e) {
            res.setStatus(401);
        }


    }
}
