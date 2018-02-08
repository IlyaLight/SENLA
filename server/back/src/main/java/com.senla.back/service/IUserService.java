package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.Validate;

public interface IUserService {

    User getUserByLoginPassword(Validate validate) throws ObjectAvailabilityException;
}
