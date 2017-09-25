package com.senla.booksshop.Request;


import java.util.Comparator;

class RequestBookNameComparator implements Comparator<Request> {
    @Override
    public int compare(Request o1, Request o2) {
        return o1.getBookName().compareTo(o2.getBookName());
    }
}
