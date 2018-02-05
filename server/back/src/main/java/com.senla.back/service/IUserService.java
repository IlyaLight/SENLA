package com.senla.back.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;

public interface IUserService {

    User getUserByLoginPassword(String login, String pass) throws ObjectAvailabilityException;
}
