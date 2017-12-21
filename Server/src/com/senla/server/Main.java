package com.senla.server;

import com.senla.api.IController;
import com.senla.dependencyinjection.DIFactoriControllers;

import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        IController controller = (IController)DIFactoriControllers.getImplementation(IController.class);
        try {
            Server.runServer(controller);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
