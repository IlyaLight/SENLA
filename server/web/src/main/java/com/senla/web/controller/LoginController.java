package com.senla.web.controller;

import com.senla.api.exception.IncompleteDataException;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import com.senla.web.controller.util.CheckDataUtil;
import com.senla.web.controller.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/authentication")
public class LoginController {

    private static final String TOKEN = "token";
    private static final String STATUS = "status";
    private static final String ERROR = "Error";

    @Autowired
    IPersonService personService;

    private static final Logger LOGGER = LoggerFactory.getLogger(new Throwable() .getStackTrace()[0].getClassName());

    @PostMapping
    public void authentication(@RequestBody Login login , HttpServletResponse res) throws ObjectAvailabilityException, IncompleteDataException {
        LOGGER.info("authentication");
        CheckDataUtil.authenticationCheakData(login);
        Person person = personService.getPersonBuLogin(login);
        if (person.getActive()) {
            String token = TokenUtil.getToken(person);
            res.addCookie(new Cookie(TOKEN, token));
            res.addCookie(new Cookie(STATUS, person.getStatus().toString()));
        }else {
            res.setStatus(401);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ObjectAvailabilityException.class})
    public void handleException(Exception e, HttpServletResponse res) {
        LOGGER.error(e.getMessage());
        res.addHeader(ERROR, e.getClass().getSimpleName());
    }

}
