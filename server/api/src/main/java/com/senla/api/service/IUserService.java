package com.senla.api.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;

public interface IUserService {

    User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException;

    User getCurrentUser() throws ObjectAvailabilityException;

    User getByPk(Integer l) throws ObjectAvailabilityException;
}
