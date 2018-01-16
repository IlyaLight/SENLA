package com.senla.booksshop.utility;

import java.util.Collection;

/**
 * Created by Light on 24.09.2017.
 */
public class Printer {
    static public void printCollection(Collection collection){
        for (Object o : collection) {
            System.out.println(o);
        }
    }
}
