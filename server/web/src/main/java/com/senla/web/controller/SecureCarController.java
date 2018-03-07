package com.senla.web.controller;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;
import com.senla.api.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class SecureCarController {

    private static final String ERROR = "Error";

    @Autowired
    ICarService carServise;

    @PostMapping("/createCar")
    public void createCar(@RequestBody Car car, HttpServletResponse res) {
        try {
            carServise.createCar(car);
        } catch (NotEnoughPermitsException e) {
            res.setStatus(400);
           res.addHeader(ERROR, e.getClass().getSimpleName());
        }
    }
}
