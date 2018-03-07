package com.senla.api.service;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;

public interface ICarService {
    void createCar(Car car) throws NotEnoughPermitsException;
}
