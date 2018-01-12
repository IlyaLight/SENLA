package com.senla.dependencyinjection;


import com.senla.dependencyinjection.annotation.AnnotationAnalyzer;
import com.senla.properties.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public final class DiControllers {

    private static Map<Class, Object> diMap = new HashMap<>();
    private static final String FILE_PATH = "Di.properties";

    private static final String EXCEPTION = "DiControllers Exception with an instance of ";
    private static final Logger LOGGER  = LoggerFactory.getLogger(PropertiesUtil.class);

    public static Object getImplementation(Class interfaceClass){
        try {
            if(!diMap.containsKey(interfaceClass)) {
                Object instance = Class.forName(PropertiesUtil.getProperties(FILE_PATH, interfaceClass.getName())).newInstance();
                diMap.put(interfaceClass, instance);
                AnnotationAnalyzer.checkObject(instance);
            }
            return diMap.get(interfaceClass);
        } catch (Exception e) {
            LOGGER.error(EXCEPTION + interfaceClass.getName(), e);
            throw new Error(e);
        }
    }
}