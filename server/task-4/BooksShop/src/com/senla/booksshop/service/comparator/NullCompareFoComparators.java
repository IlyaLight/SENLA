package com.senla.booksshop.service.comparator;

public class NullCompareFoComparators {

    static public int compare (Object o1, Object o2){
            if(o1 == null && o2 != null) {
                return -1;
            }
            else if(o1 != null && o2 == null) {
                return 1;
            }
            else return  0;
    }
}
