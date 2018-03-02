package com.senla.back;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import com.senla.api.service.IPersonService;
import com.senla.back.dao.api.IPersonDao;
import com.senla.back.dao.realization.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

    private static final Logger LOGGER  = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("rootContext.xml");
        IPersonService personService = context.getBean(IPersonService.class);
        Login login = new Login();
        login.setLogin("root");
        login.setPassword("root");
        try {
            Person person = personService.getPersonBuLogin(login);
            System.out.println(person.getName());
        } catch (ObjectAvailabilityException e) {
            e.printStackTrace();
        }


    }
}
