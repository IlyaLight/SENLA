package com.senla.dependencyinjection;


import com.senla.dependencyinjection.annotation.AnnotationAnalyzer;
import com.senla.properties.PropertiesUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DIFactoriControllers {

    private static Map<Class, Object> diMap = new HashMap<>();
    private static final String FILE_PATH = ".properties";

    private static final String EXCEPTION = "Exception:";
    private static Logger log = Logger.getLogger(DIFactoriControllers.class.getName());

    public static Object getImplementation(Class interfaceClass){
        try {
            if(!diMap.containsKey(interfaceClass)) {
                Object instance = Class.forName(PropertiesUtil.getProperties(FILE_PATH, interfaceClass.getName())).newInstance();
                diMap.put(interfaceClass, instance);
                AnnotationAnalyzer.checkObject(instance);
            }
            return diMap.get(interfaceClass);
        } catch (Exception e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new Error(e);
        }
    }
}
