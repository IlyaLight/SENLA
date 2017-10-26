package com.senla.annotation;

public class Main {

    public static void main(String[] args) {

        A a = new A();
        AnnotationAnalyzer.parse(A.class);
    }
}
