package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;

public interface IUserService {

    User getUserByLoginPassword(UserValidate userValidate) throws ObjectAvailabilityException;
}
