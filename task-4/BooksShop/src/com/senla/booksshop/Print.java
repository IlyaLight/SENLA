package com.senla.booksshop;

import java.util.Collection;

/**
 * Created by Light on 24.09.2017.
 */
public class Print {
    static public void printCollection(Collection collection){
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
