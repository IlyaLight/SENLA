package com.senla.back;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Car;
import com.senla.api.model.Login;
import com.senla.api.model.Person;
import com.senla.api.service.ICarService;
import com.senla.api.service.ILoginService;
import com.senla.api.service.IPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Test {

    private static final Logger LOGGER  = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("rootContext.xml");
        IPersonService personService = context.getBean(IPersonService.class);
        ILoginService loginService = context.getBean(ILoginService.class);
        ICarService carService = context.getBean(ICarService.class);

        Login login = new Login();
        login.setLogin("root_1");
        login.setPassword("root_1");
        try {
            Person person = personService.getPersonBuLogin(login);
            System.out.println(person.getEmail());
        } catch (ObjectAvailabilityException e) {
            e.printStackTrace();
        }

//        System.out.println(loginService.checkLoginDuplicate("root"));

//        login.setLogin("root_2");
//        login.setPassword("root_2");
//        Person person = new Person("person_2", "admin_2", "@email_2", true, login);
//        try {
//            personService.addBuyer(person);
//        } catch (AlreadyHaveThisLoginException | IncompleteDataException e) {
//            e.printStackTrace();
//        }

        List<Long> list= new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        List<Car> cars= carService.getByIdList(list);
        System.out.println(cars);

        cars = carService.getAll();
        System.out.println(cars);

    }
}
