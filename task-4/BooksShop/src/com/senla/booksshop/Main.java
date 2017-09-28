package com.senla.booksshop;


import com.senla.booksshop.collection.CollectionOrder;
import com.senla.booksshop.collection.CollectionRequest;
import com.senla.booksshop.objekt.Book;
import com.senla.booksshop.objekt.Order;
import com.senla.booksshop.objekt.Request;
import com.senla.booksshop.collection.CollectionBook;
import com.senla.booksshop.sorted.SortedBook;

import java.util.ArrayList;
import java.util.Date;


public class Main {

    public static void main(String[] args) {

        System.out.println("Book_Shop");
        System.out.println("args0 = " + args[0]);
        //testCreate("d:/");
        CollectionBook collectionBook = new CollectionBook();
        collectionBook.readFromFile(args[0] + "/books.txt");
        CollectionRequest collectionRequest = new CollectionRequest();
        CollectionOrder collectionOrder = new CollectionOrder();
        SortedBook sortedBook = new SortedBook(collectionBook.getBookList());
        Print.printCollection(sortedBook.getBooksSortedByName());
    }

    public static void testCreate(String path){
        CollectionBook collectionBook = new CollectionBook();
        ArrayList<Book> books = collectionBook.getBookList();
        books.add(new Book("x", new Date(1962, 2, 1), (float)151.12, false));
        books.add(new Book("a", new Date(1962, 2, 1), (float)90, true));
        books.add(new Book("b", new Date(1970, 2, 1), (float)151, true));
        books.add(new Book("c", new Date(1989, 2, 1), (float)40.5, true));

        CollectionRequest collectionRequest = new CollectionRequest();
        ArrayList<Request> requests = collectionRequest.getRequestArrayList();
        requests.add(new Request("x", true));
        requests.add(new Request("x", false));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("c", true));
        requests.add(new Request("a", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("b", true));
        requests.add(new Request("x", false));

        CollectionOrder collectionOrder = new CollectionOrder();
        ArrayList<Order> orders = collectionOrder.getOrderArrayList();
        orders.add(new Order("c", (float)50, new Date(), "transit", false));
        orders.add(new Order("c", (float)40, new Date(), "transit", false));
        orders.add(new Order("c", (float)40, new Date(), "transit", false));
        orders.add(new Order("x", (float)150, new Date(), "delivery", true));

        collectionOrder.writeToFile(path + "orders.txt");
        collectionRequest.writeToFile(path + "request.txt");
        collectionBook.writeToFile(path + "books.txt");

    }
}
