package com.senla.api.service;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;

import java.util.List;

public interface ICarService {
    void create(Car car) throws NotEnoughPermitsException;

    void delete(Car car) throws NotEnoughPermitsException;

    void update(Car car) throws NotEnoughPermitsException;

    List<Car> getAll();

    Car getById(Long id);

    List<Car> getByIdList(List<Long> idList);
}
