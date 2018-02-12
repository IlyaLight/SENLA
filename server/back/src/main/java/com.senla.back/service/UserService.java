package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;

import com.senla.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    UsertIdHandler handler;

    public User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException {
        return userDao.getUserByLoginPassword(userValidate);
    }

    @Override
    public User getCurrentUser() throws ObjectAvailabilityException {
        return userDao.getByPk(handler.getId());
    }
}
