package com.senla.back.service;

import com.senla.api.exception.AlreadyHaveThisLoginException;
import com.senla.api.exception.IncompleteDataException;
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

    @Autowired
    IPersonHandler personHandler;

    @Transactional(readOnly=true)
    @Override
    public Person getPersonBuLogin(Login login) throws ObjectAvailabilityException{
        return personDao.getPersonBuLogin(login);
    }

    /** adds a buyer **/

    @Override
    public void addBuyer(Person person){
        person.setStatus(Person.Status.BUYER);
        personDao.create(person);
    }

    @Transactional(readOnly=true)
    @Override
    public Person getByPk(Long id) throws ObjectAvailabilityException {
        return personDao.getByPk(id);
    }

    @Transactional(readOnly=true)
    @Override
    public Person getPerson() {
        return personHandler.getPerson();
    }

    @Override
    public void savePerson(Person person) {

    }


    public void updatePerson(Person person)throws AlreadyHaveThisLoginException {

    }


}
