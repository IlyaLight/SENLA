package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;

import com.senla.api.service.IUserService;
import com.senla.back.dao.api.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    @Autowired
    UserHandler handler;

    @Override
    public User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException {
        return userDao.getUserByLoginPassword(userValidate);
    }

    @Override
    public User getCurrentUser() throws ObjectAvailabilityException {
        return handler.getUser();
    }

    @Override
    public User getByPk(Integer l) throws ObjectAvailabilityException {
        return userDao.getByPk(l);
    }


}
