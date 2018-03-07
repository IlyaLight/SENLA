package com.senla.web.controller;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.IncompleteDataException;
import com.senla.api.model.Car;
import com.senla.api.model.Person;
import com.senla.api.service.ICarServise;
import com.senla.back.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class SecureCarController {

    @Autowired
    ICarServise carServise;

    @PostMapping("/createCar")
    public void createCar(@RequestBody Car car, HttpServletResponse res) {
//        try {
//            carServise.(person);
//        } catch (AlreadyHaveThisLoginException e) {
//            res.setStatus(400);
//            res.addHeader(ERROR, e.getClass().getSimpleName());
//        } catch (IncompleteDataException e) {
//            res.setStatus(400);
//            res.addHeader(ERROR, e.getClass().getSimpleName());
//        }
    }
}
