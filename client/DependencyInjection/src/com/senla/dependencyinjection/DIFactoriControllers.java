package com.senla.dependencyinjection;


import com.senla.dependencyinjection.annotation.AnnotationAnalyzer;
import com.senla.properties.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DIFactoriControllers {

    private static Map<Class, Object> diMap = new HashMap<>();
    private static final String FILE_PATH = "DIFactori.properties";

    private static final String EXCEPTION = "Exception:";
    public static final String COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION = "Could't find or instance an implementation...";
    private static Logger log = Logger.getLogger(DIFactoriControllers.class.getName());

    public static Object getController(Class interfaceClass){
        try {
            if(!diMap.containsKey(interfaceClass)) {
                diMap.put(interfaceClass, PropertiesUtil.getProperties(FILE_PATH, interfaceClass.getName()));
            }
            Object instance = Class.forName(diMap.get(interfaceClass).toString()).newInstance();
            AnnotationAnalyzer.checkObject(instance);
            return instance;
        } catch (Exception e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new Error(e);
        }
    }
}
