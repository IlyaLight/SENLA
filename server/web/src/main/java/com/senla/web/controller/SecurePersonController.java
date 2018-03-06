package com.senla.web.controller;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import com.senla.back.service.IPersonHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class SecurePersonController {

    @Autowired
    IPersonService personService;

    @GetMapping("/getPerson")
    public @ResponseBody Person getCurrentPerson(HttpServletResponse res) {
        Person person = personService.getPerson();
        if (person == null){
            res.setStatus(500);
        }
        return person;
    }

    @PostMapping("/savePerson")
    public @ResponseBody Person savePerson(HttpServletResponse res) {
        Person person = personService.getPerson();
        if (person == null){
            res.setStatus(500);
        }
        return person;
    }


}
