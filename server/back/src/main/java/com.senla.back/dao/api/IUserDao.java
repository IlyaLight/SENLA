package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;

public interface IUserDao extends IGenericDao<User> {
    User getUserByLoginPassword(String login, String password) throws ObjectAvailabilityException;
}
