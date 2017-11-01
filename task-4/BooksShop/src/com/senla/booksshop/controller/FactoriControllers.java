package com.senla.booksshop.controller;

import com.senla.annotation.AnnotationAnalyzer;
import com.senla.properties.PropertyNotFoundException;
import com.senla.booksshop.utility.WorkWithFile;
import com.senla.properties.IPropertiesHolder;
import com.senla.properties.PropertiesHolder;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class FactoriControllers {
    public static final String COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION = "Could't find or instance an implementation...";
    public static final String CAN_NOT_CREATE_INSTANCE_OF_PROPERTIES_HOLDER = "can not create instance of PropertiesHolder";
    private static Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public static IController getIController(Class<? extends IController> clazz){
        IController controller;
        try {
            controller = clazz.newInstance();
        }catch (ReflectiveOperationException e){
            log.log(Level.SEVERE, COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION, e);
            return null;
        }
        try {
            controller.setPropertiesHolder((IPropertiesHolder)AnnotationAnalyzer.getExemplar(PropertiesHolder.class));
        } catch (IllegalAccessException | InstantiationException | PropertyNotFoundException e) {
            log.log(Level.SEVERE, CAN_NOT_CREATE_INSTANCE_OF_PROPERTIES_HOLDER, e);
            return null;
        }

        return controller;
    }
}
