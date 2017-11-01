package com.senla.annotation;

import com.senla.properties.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DIFactoriControllers {

    private static Map<Class, Object> diMap = new HashMap<>();

    private static final String EXCEPTION = "Exception:";
    public static final String COULD_T_FIND_OR_INSTANCE_AN_IMPLEMENTATION = "Could't find or instance an implementation...";
    private static Logger log = Logger.getLogger(DIFactoriControllers.class.getName());

    public static Object getController(Class interfaceClass){
        if(!diMap.containsKey(interfaceClass)) {
            try {
                diMap.put(interfaceClass, PropertiesUtil.getProperties(DIFactoriControllers.class.getSimpleName(), interfaceClass.getName()));
                Object instance = Class.forName(diMap.get(interfaceClass).toString()).newInstance();
                AnnotationAnalyzer.checkObject(instance);
                return instance;
            } catch (Exception e) {
                log.log(Level.SEVERE, EXCEPTION, e);
                throw new Error(e);
            }
        }
        return null;
    }
}
