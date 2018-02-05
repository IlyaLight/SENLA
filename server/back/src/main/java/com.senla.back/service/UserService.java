package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.back.dao.api.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService implements IUserService {

    @Autowired
    IUserDao userDao;

    public User getUserByLoginPassword(String login, String pass) throws ObjectAvailabilityException {
        return userDao.getUserByLoginPassword(login,pass);
    }
}
