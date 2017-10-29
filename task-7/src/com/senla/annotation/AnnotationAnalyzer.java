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

    private static final String STANDART_CONFIG_FILE = "config.properties";
    private static final String EXCEPTION = "Exception:";
    private static final Map<String, Properties> propertiesFilesMap = new  HashMap<>();
    private static final Map<String, Object> propertiesMap = new HashMap<>();

    public static void parseTest(Class<?> clazz){
        System.out.println("\n\n---parseTest---");
        Field[] fildes = clazz.getFields();
        ConfigProperty anno;
        for (Field filde : fildes) {
            anno = filde.getAnnotation(ConfigProperty.class);
            System.out.println("fild:" + filde.getName());
            System.out.println("tipe:" + filde.getType().getName());
            if (anno != null) {
                System.out.println(anno.configName());
                System.out.println(anno.propertyName());
                System.out.println(anno.type());
            }else {
                System.out.println("no annotation");
            }
            System.out.println("---------------");
        }
    }

    public static Object getExemplar(Class<?> clazz) throws IllegalAccessException, InstantiationException, PropertyNotFoundException {
        Object exemplar = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        ConfigProperty anno;
        for (Field field : fields) {
            anno = field.getAnnotation(ConfigProperty.class);
            if (anno != null) {
                String configName = anno.configName();
                if (Objects.equals(configName, ConfigProperty.DEFAULT)) {
                    configName = STANDART_CONFIG_FILE;
                }
                String propertyName = anno.propertyName();
                if (Objects.equals(propertyName, ConfigProperty.DEFAULT)) {
                    propertyName = clazz.getSimpleName() + "." + field.getName();
                }
                ConfigProperty.Type fildType = anno.type();
                field.setAccessible(true);
                field.set(exemplar, getFieldValue(configName, propertyName, fildType));

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
            Object value;
            switch (fieldType){
                case INT:
                    value = new Integer(propertiesFilesMap.get(configName).getProperty(propertyName));
                    testValue(value, propertyName);
                    propertiesMap.put(propertyName, new Integer(propertiesFilesMap.get(configName).getProperty(propertyName)));
                    break;
                case STRING:
                    value = propertiesFilesMap.get(configName).getProperty(propertyName);
                    testValue(value, propertyName);
                    propertiesMap.put(propertyName, value);
                    break;
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
