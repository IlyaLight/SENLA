package com.senla.back.service;

import com.senla.api.model.Person;

public interface IPersonHandler {
    Person getPerson();

    void setPerson(Person person);
}
