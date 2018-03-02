package com.senla.back.service;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import com.senla.back.dao.api.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    IPersonDao personDao;

    @Override
    public Person getPersonBuLogin(Login login) throws ObjectAvailabilityException{
        return personDao.getPersonBuLogin(login);
    }

    public void addPerson(Login login) throws AlreadyHaveThisLoginException{

    }

    public void updatePerson(Person person)throws AlreadyHaveThisLoginException {

    }

}
