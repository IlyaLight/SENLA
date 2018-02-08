package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.Validate;

public interface IUserDao extends IGenericDao<User> {
    User getUserByLoginPassword(Validate validate) throws ObjectAvailabilityException;
}
