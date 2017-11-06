package com.senla.ui;

import com.senla.dependencyinjection.DIFactoriControllers;
import com.senla.ui.controller.IUIController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //WorkWithFile.createFiles("");
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream("logging.properties"));
        }catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        IUIController uiController = (IUIController)DIFactoriControllers.getController(IUIController.class);
        uiController.run();
    }
}
