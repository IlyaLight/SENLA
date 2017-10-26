package com.senla.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {

    enum  Type {INT, DEFAULT, STRING
    }

    String configName() default "null";
    String propertyName() default "null";;
    Type type() default Type.DEFAULT;
}
