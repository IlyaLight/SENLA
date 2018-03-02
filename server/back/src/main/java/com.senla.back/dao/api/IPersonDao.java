package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;

public interface IPersonDao extends IGenericDao<Person>{

    Person getPersonBuLogin(Login login) throws ObjectAvailabilityException;
}
