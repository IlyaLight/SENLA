package com.senla.server;

import com.senla.api.IController;
import com.senla.dependencyinjection.DIFactoriControllers;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.PatternLayout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {


    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("log4j.properties");
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pattern = prop.getProperty("log4j.appender.stdout.layout.conversionPattern");
        BasicConfigurator.configure(new ConsoleAppender(new PatternLayout(pattern)));

        IController controller = (IController)DIFactoriControllers.getImplementation(IController.class);
        try {
            Server.runServer(controller);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
