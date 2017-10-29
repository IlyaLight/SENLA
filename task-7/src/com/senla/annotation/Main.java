package com.senla.annotation;

public class Main {

    public static void main(String[] args) {

        //new A();

        try {
            A a = (A)AnnotationAnalyzer.getExemplar(A.class);
            System.out.println(a.getIntTest());
            System.out.println(a.getStringTest());
            System.out.println(a.getNoAnnotation());
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
