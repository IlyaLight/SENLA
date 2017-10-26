package com.senla.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationAnalyzer {
    public void parse(Class<?> clazz) throws Exception {
        Field[] fildes = clazz.getFields();
        int pass = 0;
        int fail = 0;

        for (Field filde : fildes) {
            if (filde.isAnnotationPresent(ConfigProperty.class)) {
                try {
                    pass++;
                } catch (Exception e) {
                    fail++;
                }
            }
        }
    }
}
