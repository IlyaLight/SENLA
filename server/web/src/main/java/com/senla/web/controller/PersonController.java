package com.senla.web.controller;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.IncompleteDataException;
import com.senla.api.model.Person;
import com.senla.api.service.ILoginService;
import com.senla.api.service.IPersonService;
import com.senla.web.controller.util.CheckDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class PersonController {

    private static final String ERROR = "Error";

    private static final Logger LOGGER = LoggerFactory.getLogger(new Throwable() .getStackTrace()[0].getClassName());

    @Autowired
    IPersonService personService;
    @Autowired
    ILoginService loginService;


    @PostMapping("/createBuyer")
    public void createBuyer(@RequestBody Person person, HttpServletResponse res) throws IncompleteDataException, AlreadyHaveThisLoginException {
        LOGGER.info("createBuyer");
        CheckDataUtil.createBuyerCheckData(person);
        if (loginService.checkLoginDuplicate(person.getLogin())){
            throw new AlreadyHaveThisLoginException();
        }
        personService.addBuyer(person);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IncompleteDataException.class, AlreadyHaveThisLoginException.class})
    public void handleException(Exception e, HttpServletResponse res) {
        LOGGER.error(e.getMessage());
        res.addHeader(ERROR, e.getClass().getSimpleName());
    }


}
