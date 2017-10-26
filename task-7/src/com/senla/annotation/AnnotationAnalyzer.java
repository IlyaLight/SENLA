package com.senla.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class AnnotationAnalyzer {

    private List<String> propertiesFiles = new ArrayList<>();
    private Map<String, String> properties = new TreeMap();

    public static void parseTest(Class<?> clazz){
        Field[] fildes = clazz.getFields();
        for (Field filde : fildes) {
            ConfigProperty anno = filde.getAnnotation(ConfigProperty.class);
            System.out.println("fild:" + filde.getName());
            System.out.println("tipe:" + filde.getType().getName());
            System.out.println(anno.configName());
            System.out.println(anno.propertyName());
            System.out.println(anno.type());
            System.out.println("---------------");
        }
    }

    public static void configureOject(Object object){
        Class clazz = object.getClass();
        String className = clazz.getName();
        Field[] fildes = clazz.getFields();
        for (Field filde : fildes){

        }
    }
}
