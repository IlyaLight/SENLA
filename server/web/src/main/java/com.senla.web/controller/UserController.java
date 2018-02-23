package com.senla.web.controller;


import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class UserController {

    @Autowired
    IUserService userService;


   @GetMapping ("/getUser")
    public @ResponseBody User getUser(HttpServletResponse res) {
       try {
           return userService.getCurrentUser();
       } catch (ObjectAvailabilityException e) {
           res.setStatus(500);
       }
       return null;
   }
}
