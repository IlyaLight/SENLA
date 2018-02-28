package com.senla.back;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

    private static final Logger LOGGER  = LoggerFactory.getLogger(Test.class);


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("rootContext.xml");


    }
}
