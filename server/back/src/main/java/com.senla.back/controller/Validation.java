package com.senla.back.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.back.controller.util.TokenUtil;
import com.senla.back.dao.api.IUserDao;
import com.senla.back.service.IUserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("login")
public class Validation {

    @Autowired
    IUserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(Validation.class);;

    @RequestMapping(method = RequestMethod.GET)
    public void validation(@RequestParam(value="login") String login,
                                     @RequestParam(value="password") String password,
                                     HttpServletResponse response) {
        LOGGER.info("login_GET");
        try {
            String token = TokenUtil.getToken(userService.getUserByLoginPassword(login, password));
            response.addHeader("token", token);
        } catch (ObjectAvailabilityException e) {
            response.setStatus(401);
        }


    }

}
