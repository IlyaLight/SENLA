package com.senla.dependencyinjection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {

    String DEFAULT = "default";

    enum  Type {INT, STRING, BOOLEAN
    }

    String configName() default DEFAULT;
    String propertyName() default DEFAULT;
    Type type() default Type.STRING;
}
