package com.senla.ui.controller;

import com.senla.booksshop.controller.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FactoriControllers {

    public static final String COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION = "Could't find or instance an implementation...";
    private static Logger log = Logger.getLogger(FactoriControllers.class.getName());

    public static IMenuController getIMenuController(Class<? extends IMenuController> clazz) throws IllegalAccessException, InstantiationException {
        IMenuController controller;
        try {
            controller = clazz.newInstance();
       }catch (ReflectiveOperationException e){
           log.log(Level.SEVERE, COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION, e);
           return null;
       }
       controller.setShopController(com.senla.booksshop.controller.FactoriControllers.getIController(Controller.class));

        return  controller;
    }
}
