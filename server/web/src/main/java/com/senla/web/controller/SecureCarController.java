package com.senla.web.controller;

import com.senla.api.exception.IncompleteDataException;
import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;
import com.senla.api.service.ICarService;
import com.senla.web.controller.util.CheckDataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class SecureCarController {

    private static final String ERROR = "Error";

    private static final Logger LOGGER = LoggerFactory.getLogger(new Throwable() .getStackTrace()[0].getClassName());

    @Autowired
    ICarService carService;

    @PostMapping("/createCar")
    public void createCar(@RequestBody Car car) throws NotEnoughPermitsException, IncompleteDataException {
        LOGGER.info("create");
        CheckDataUtil.createCarCheckData(car);
        carService.create(car);
    }

    @DeleteMapping("/deleteCar")
    public void deleteCar (@RequestBody Car car)  throws NotEnoughPermitsException {
        LOGGER.info("delete");
        carService.delete(car);
    }

    @PostMapping("/updateCar")
    public void updateCar (@RequestBody Car car)  throws NotEnoughPermitsException, IncompleteDataException {
        LOGGER.info("update");
        CheckDataUtil.updateCarCheckData(car);
        carService.update(car);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NotEnoughPermitsException.class, IncompleteDataException.class})
    public void handleNotEnoughPermitsException(Exception e, HttpServletResponse res) {
        LOGGER.error(e.getMessage());
        res.addHeader(ERROR, e.getClass().getSimpleName());
    }

}
