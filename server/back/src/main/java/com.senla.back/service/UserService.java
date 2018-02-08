package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.Validate;
import com.senla.back.dao.api.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    public User getUserByLoginPassword(Validate validate) throws ObjectAvailabilityException {
        return userDao.getUserByLoginPassword(validate);
    }
}
