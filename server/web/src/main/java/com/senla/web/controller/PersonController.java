package com.senla.web.controller;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.IncompleteDataException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLIntegrityConstraintViolationException;

@Controller
@RequestMapping
public class PersonController {

    private static final String ERROR = "Error";

    @Autowired
    IPersonService personService;


    @PostMapping("/createPerson")
    public void createPerson(@RequestBody Person person, HttpServletResponse res) {
        try {
            personService.addPerson(person);
        } catch (SQLIntegrityConstraintViolationException e) {
            res.setStatus(400);
            res.addHeader(ERROR, e.getClass().getSimpleName());
        } catch (IncompleteDataException e) {
            res.setStatus(400);
            res.addHeader(ERROR, e.getClass().getSimpleName());
        }
    }

}
