package com.senla.booksshop;


import com.senla.booksshop.controller.Shop;
import com.senla.booksshop.stores.OrderCollection;
import com.senla.booksshop.stores.RequestCollection;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.stores.BookCollection;
import com.senla.booksshop.servis.BookSorter;
import com.senla.booksshop.utility.Printer;
import com.senla.booksshop.utility.WorkWithFile;

import java.util.ArrayList;
import java.util.Date;


public class Main {

    static final String  STANDART_PATH = "d:/";

    public static void main(String[] args) {

        System.out.println("Book_Shop");
        String path = STANDART_PATH;
        if (args.length > 0) {
            System.out.println("args0 = " + args[0]);
            path = args[0];
        }
        //testCreate(path);
        testReadWritetoFile(path);
    }

    public static void testCreate(String path){
        Shop shop = new Shop();

        BookCollection bookCollection = new BookCollection();
        ArrayList<Book> books = bookCollection.getBookList();
        books.add(new Book("x", new Date(1962, 2, 1), (float)151.12, 1));
        books.add(new Book("a", new Date(1962, 2, 1), (float)90, 0));
        books.add(new Book("b", new Date(1970, 2, 1), (float)151, 11));
        books.add(new Book("c", new Date(1989, 2, 1), (float)40.5, 3));
        BookCollection bookCollection1 = new BookCollection();
        bookCollection.setBookList(books);

        RequestCollection requestCollection = new RequestCollection();
        ArrayList<Request> requests = requestCollection.getRequestArrayList();
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

        OrderCollection orderCollection = new OrderCollection();
        ArrayList<Order> orders = orderCollection.getOrderArrayList();
        orders.add(new Order("c", (float)50, new Date(), "transit", false));
        orders.add(new Order("c", (float)40, new Date(), "transit", false));
        orders.add(new Order("c", (float)40, new Date(), "transit", false));
        orders.add(new Order("x", (float)150, new Date(), "delivery", true));

        shop.setBookCollection(bookCollection);
        shop.setOrderCollection(orderCollection);
        shop.setRequestCollection(requestCollection);

        shop.writeToFile(path);

    }

    public static void testReadWritetoFile(String path){
        Shop shop = new Shop();
        shop.readFromFile(path);
        shop.writeToFile(path);
        Printer.printCollection(BookSorter.getBooksSortedByName(shop.getBookCollection().getBookList()));
    }

}
