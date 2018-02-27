package com.senla.back;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.User;
import com.senla.api.model.UserValidate;
import com.senla.api.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

    private static final Logger LOGGER  = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        ApplicationContext context = new ClassPathXmlApplicationContext("rootContext.xml");
        IUserService userDao = (IUserService) context.getBean("UserService");

        try {
            UserValidate userValidate = new UserValidate();
            userValidate.setPass("root");
            userValidate.setLogin("root");
            User user = userDao.getUserByLoginPassword(userValidate);
            System.out.println(user.getUserName());
        } catch (ObjectAvailabilityException e) {
            e.printStackTrace();
        }

    }
}
