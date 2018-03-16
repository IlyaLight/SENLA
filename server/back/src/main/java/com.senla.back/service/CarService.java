package com.senla.back.service;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.model.Car;
import com.senla.api.model.Person;
import com.senla.api.service.ICarService;
import com.senla.back.dao.api.ICarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarService implements ICarService {

    @Autowired
    ICarDao carDao;

    @Autowired
    IPersonHandler personHandler;

    @Override
    public void create(Car car) throws NotEnoughPermitsException {
        if (personHandler.getPerson().getStatus()!= Person.Status.ADMINISTRATOR){
            throw new NotEnoughPermitsException();
        }
        carDao.create(car);
    }

    @Override
    public void delete(Car car) throws NotEnoughPermitsException {
        carDao.delete(car);
    }

    @Override
    public void update(Car car) throws NotEnoughPermitsException {
        carDao.update(car);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    @Override
    public Car getById(Long id) {
        return carDao.getByPk(id);
    }

    @Override
    public List<Car> getByIdList(List<Long> idList){
        return carDao.getById(idList);
    }
}
