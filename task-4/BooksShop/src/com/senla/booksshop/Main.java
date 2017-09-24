package com.senla.booksshop;

import com.senla.booksshop.Request.Request;
import com.senla.booksshop.Request.RequestBookNameComparator;
import com.senla.booksshop.Request.RequestNumberRequestComparator;
import static com.senla.booksshop.Print.printCollection;

import java.util.ArrayList;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request("a", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("a", true));


        BookShopDataBase bookShopDataBase = new BookShopDataBase();
        bookShopDataBase.setRequestArrayList(requests);
        ArrayList<String> names = bookShopDataBase.getRequstSortedNumberRequst();
        printCollection(names);
    }
}
