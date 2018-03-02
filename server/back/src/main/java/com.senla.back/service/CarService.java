package com.senla.back.service;

import com.senla.api.service.ICarServise;
import com.senla.back.dao.api.ICarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarService implements ICarServise {

    @Autowired
    ICarDao carDao;
}
