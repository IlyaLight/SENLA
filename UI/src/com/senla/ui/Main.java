package com.senla.ui;

import com.senla.booksshop.controller.Controller;
import com.senla.ui.controller.UIController;

import java.io.IOException;
import java.util.logging.LogManager;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //WorkWithFile.createFiles("");
        try {
            LogManager.getLogManager().readConfiguration(com.senla.ui.Main.class.getResourceAsStream("/logging.properties"));
        }catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }
        UIController uiController = new UIController(new Controller(),"");
        uiController.run();
    }
}
