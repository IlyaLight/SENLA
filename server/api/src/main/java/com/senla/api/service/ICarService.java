package com.senla.api.service;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;

public interface ICarService {
    void createCar(Car car) throws NotEnoughPermitsException;

    void deleteCar(Long id) throws NotEnoughPermitsException;

    void updateCar(Car car) throws NotEnoughPermitsException;
}
