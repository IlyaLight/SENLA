package com.senla.back.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import org.springframework.transaction.annotation.Transactional;

public interface IPersonDao {
    @Transactional
    Person getPersonBuLogin(Login login) throws ObjectAvailabilityException;
}
