package com.senla.back.dao.api;

import com.senla.api.model.Car;

import java.util.List;

public interface ICarDao extends IGenericDao<Car> {
    List<Car> getById(List<Long> idList);
}
