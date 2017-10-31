package com.senla.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
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
    private static final Map<String, Properties> propertiesFilesMap = new  HashMap<>();
    private static final Map<String, Object> propertiesMap = new HashMap<>();


    public static Object getExemplar(Class<?> clazz) throws IllegalAccessException, InstantiationException, PropertyNotFoundException {
        Object exemplar = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            ConfigProperty annoCP = field.getAnnotation(ConfigProperty.class);
            if (annoCP != null) {
                String configName = annoCP.configName();
                if (Objects.equals(configName, ConfigProperty.DEFAULT)) {
                    configName = DEFAULT_CONFIG_FILE;
                }
                String propertyName = annoCP.propertyName();
                if (Objects.equals(propertyName, ConfigProperty.DEFAULT)) {
                    propertyName = clazz.getSimpleName() + "." + field.getName();
                }
                ConfigProperty.Type fieldType = annoCP.type();
                field.setAccessible(true);
                field.set(exemplar, getFieldValue(configName, propertyName, fieldType));

            }
            ContainsConfigProperty annoCCP = field.getAnnotation(ContainsConfigProperty.class);
            if (annoCCP != null){
                Object object = getExemplar(field.getType()); //recursion
                field.set(exemplar, object);
            }
        }
        return exemplar;
    }

    private static Object getFieldValue(String configName, String propertyName, ConfigProperty.Type fieldType) throws PropertyNotFoundException{

        if (!propertiesFilesMap.containsKey(configName)){
            Properties properties = new Properties();
            try (FileInputStream file = new FileInputStream(configName)){
                properties.load(file);
            }catch (IOException e){
                log.log(Level.SEVERE, EXCEPTION, e);
                throw new RuntimeException(e);
            }
            propertiesFilesMap.put(configName, properties);
        }
        if (!propertiesMap.containsKey(propertyName)){
            Object value = propertiesFilesMap.get(configName).getProperty(propertyName);
            testValue(value, propertyName);
            switch (fieldType){
                case INT:
                    propertiesMap.put(propertyName, Integer.getInteger(value.toString()));
                    break;
                case STRING:
                    propertiesMap.put(propertyName, value);
                    break;
                case BOOLEAN:
                    propertiesMap.put(propertyName, Boolean.getBoolean(value.toString()));
            }
        }
        return propertiesMap.get(propertyName);


    }


    private static void testValue(Object o, String propertyName) throws PropertyNotFoundException {
        if (o == null) {
            Exception e = new PropertyNotFoundException(propertyName);
            log.log(Level.SEVERE, EXCEPTION, e);
            throw (PropertyNotFoundException) e;
        }
    }


}
