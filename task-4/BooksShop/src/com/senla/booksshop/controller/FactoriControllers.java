package com.senla.booksshop.controller;

import com.senla.booksshop.utility.WorkWithFile;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FactoriControllers {
    public static final String COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION = "Could't find or instance an implementation...";
    private static Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public static IController getIController(Class<? extends IController> clazz){
        IController controller;
        try {
            controller = clazz.newInstance();
        }catch (ReflectiveOperationException e){
            log.log(Level.SEVERE, COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION, e);
            return null;
        }

        return controller;
    }
}
