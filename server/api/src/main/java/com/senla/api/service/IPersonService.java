package com.senla.api.service;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.IncompleteDataException;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;

public interface IPersonService {
    Person getPersonBuLogin(Login login) throws ObjectAvailabilityException;

    void addPerson(Person person) throws AlreadyHaveThisLoginException, IncompleteDataException;
}
