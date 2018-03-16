package com.senla.web.controller;

import com.senla.api.model.Car;
import com.senla.api.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping
public class CarController {

    private static final Logger LOGGER = LoggerFactory.getLogger(new Throwable() .getStackTrace()[0].getClassName());

    @Autowired
    ICarService carService;

    @GetMapping("/getAllCars")
    public @ResponseBody List<Car> getAllCars(HttpServletResponse res) {
        return carService.getAll();
    }
}
