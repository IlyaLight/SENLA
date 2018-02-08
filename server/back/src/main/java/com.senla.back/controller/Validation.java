package com.senla.back.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Validate;
import com.senla.back.controller.util.TokenUtil;
import com.senla.back.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class Validation {

    public static final String TOKEN = "token";
    @Autowired
    IUserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Validation.class);;

    @RequestMapping( method = RequestMethod.GET, consumes="application/json")
    public void validation(@RequestBody Validate validate, HttpServletResponse res) {
        LOGGER.info("login_GET");
        try {
            String token = TokenUtil.getToken(userService.getUserByLoginPassword(validate));
            res.addCookie(new Cookie(TOKEN, token));
        } catch (ObjectAvailabilityException e) {
            res.setStatus(401);
        }


    }

}
