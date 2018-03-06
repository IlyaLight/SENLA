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

@Controller
@RequestMapping
public class PersonController {

    @Autowired
    IPersonService personService;


    @PostMapping("/createPerson")
    public void createPerson(@RequestBody Person person, @RequestBody Login login, HttpServletResponse res) {
      person.setLogin(login);
        try {
            personService.addPerson(person);
        } catch (AlreadyHaveThisLoginException e) {
            res.setStatus(400);
            res.addHeader("Erro");
        } catch (IncompleteDataException e) {
            e.printStackTrace();
        }
    }

}
