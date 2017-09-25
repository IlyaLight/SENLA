package com.senla.booksshop;


import com.senla.booksshop.Request.Request;
import com.senla.booksshop.Request.SortedRequest;

import java.util.ArrayList;

import static com.senla.booksshop.Print.printCollection;

public class Main {

    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request("x", true));
        requests.add(new Request("x", true));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("a", false));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("x", true));


        SortedRequest sortedDataBase = new SortedRequest();
        sortedDataBase.setRequestArrayList(requests);
        ArrayList<Request> names = sortedDataBase.getRequstSortedNumberRequst();
        printCollection(names);
    }
}
