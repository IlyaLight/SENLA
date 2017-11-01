package com.senla.dependencyinjection.annotation;

import com.senla.dependencyinjection.DIFactoriControllers;
import com.senla.properties.PropertiesUtil;
import com.senla.properties.PropertyNotFoundException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnnotationAnalyzer {

    //On Demand Holder
    public static class SingletonHolder {
        public static final AnnotationAnalyzer HOLDER_INSTANCE = new AnnotationAnalyzer();
    }

    public static AnnotationAnalyzer getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    private static final Logger log = Logger.getLogger(AnnotationAnalyzer.class.getName());

    private static final String DEFAULT_CONFIG_FILE = "config.properties";
    private static final String EXCEPTION = "Exception:";
    private static final Map<String, Object> propertiesMap = new HashMap<>();


    public static void checkObject(Object object) throws PropertyNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Injection injection = field.getAnnotation(Injection.class);
            if (injection != null){
                setField(field, object, DIFactoriControllers.getController(field.getType()));    //recursion
            }

            ConfigProperty configProperty = field.getAnnotation(ConfigProperty.class);
            if (configProperty != null) {
                String configName = configProperty.configName();
                if (Objects.equals(configName, ConfigProperty.DEFAULT)) {
                    configName = DEFAULT_CONFIG_FILE;
                }
                String propertyName = configProperty.propertyName();
                if (Objects.equals(propertyName, ConfigProperty.DEFAULT)) {
                    propertyName = clazz.getSimpleName() + "." + field.getName();
                }
                ConfigProperty.Type fieldType = configProperty.type();
                setField(field, object, getFieldValue(configName, propertyName, fieldType));
            }
            ContainsConfigProperty containsConfigProperty = field.getAnnotation(ContainsConfigProperty.class);
            if (containsConfigProperty != null){
                Object o = field.getType().newInstance();
                checkObject(o);  //recursion
                setField(field,object, o);
            }
        }
    }

    private static void setField( Field field, Object object, Object value) throws IllegalAccessException {
        boolean fieldAccessible = field.isAccessible();
        field.setAccessible(true);
        field.set(object, value);
        field.setAccessible(fieldAccessible);
    }

    private static Object getFieldValue(String configName, String propertyName, ConfigProperty.Type fieldType) throws PropertyNotFoundException{

        if (!propertiesMap.containsKey(propertyName)){
            Object value = PropertiesUtil.getProperties(configName, propertyName);
            if (value == null) {
                Exception e = new PropertyNotFoundException(propertyName);
                log.log(Level.SEVERE, EXCEPTION, e);
                throw (PropertyNotFoundException) e;
            }
            switch (fieldType){
                case INT:
                    propertiesMap.put(propertyName, Integer.parseInt(value.toString()));
                    break;
                case STRING:
                    propertiesMap.put(propertyName, value);
                    break;
                case BOOLEAN:
                    propertiesMap.put(propertyName, Boolean.parseBoolean(value.toString()));
            }
        }
        return propertiesMap.get(propertyName);
    }

}
