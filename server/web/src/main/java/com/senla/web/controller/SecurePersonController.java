package com.senla.web.controller;

import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void savePerson(@RequestBody Person person, HttpServletResponse res) {
        personService.savePerson(person);
        //проверка ошибок
    }

//    @PostMapping("/savePerson")
//    public void saveAnotherPerson(@RequestBody Person person, HttpServletResponse res) {
//        personService.saveAnotherPerson(person);
//        //проверка ошибок
//    }
//
//    @GetMapping("/getAllPersons")
//    public @ResponseBody List<Person> getAllPersons(HttpServletResponse res){
//        return personService.getAllPersons();
//        //проверка ошибок
//    }


}
