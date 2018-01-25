package com.senla.web;

import com.senla.api.exception.ObjectAvailabilityException;

public class Main {
    public static void main(String[] args) {
//        try {
//            String s = WebController.getInstance().getOrderDetails(10);
//            System.out.println(s);
//        } catch (ObjectAvailabilityException e) {
//            e.printStackTrace();
//        }
        try {
            WebController.getInstance().addRequest(3);
        } catch (ObjectAvailabilityException e) {
            e.printStackTrace();
        }
    }
}
