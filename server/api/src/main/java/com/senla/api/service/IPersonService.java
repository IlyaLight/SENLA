package com.senla.api.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;

public interface IPersonService {
    Person getPersonBuLogin(Login login) throws ObjectAvailabilityException;
}
