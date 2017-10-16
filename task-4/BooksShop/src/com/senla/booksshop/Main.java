package com.senla.booksshop;


import com.senla.booksshop.controller.Controller;
import com.senla.booksshop.controller.IController;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.utility.Printer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;


public class Main {

    static final String  STANDART_PATH = "";

    public static void main(String[] args) throws Exception{

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        }catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }


        System.out.println("Book_Shop");
        String path = STANDART_PATH;
        if (args.length > 0) {
            System.out.println("args0 = " + args[0]);
            path = args[0];
        }

        //WorkWithFile.createFiles(path);
        //testCreate(path);
        testReadWritetoFile(path);
    }

    public static void testReadWritetoFile(String path){
        IController controller = new Controller();
        controller.readFromFile(path);

        Calendar from =Calendar.getInstance();
        Calendar to =Calendar.getInstance();
        from.set(2017, Calendar.MARCH, 1);
        to.set(2017, Calendar.OCTOBER, 1);

        Printer.printCollection(controller.getBooksSortedByName());
        Printer.printCollection(controller.getBooksSortedByDateIssue());
        Printer.printCollection(controller.getBooksSortedByPrice());
        Printer.printCollection(controller.getBooksSortedByStockAvailability());

        Printer.printCollection(controller.getOrderSortedByDataCompletion());
        Printer.printCollection(controller.getOrderSortedByPrice());
        Printer.printCollection(controller.getOrderSortedByStatus());

        Printer.printCollection(controller.getRequestSortedOfQuantity());
        Printer.printCollection(controller.getRequestSortedByBookName());

        Printer.printCollection(controller.getCompletedOrderSortedByCompletedData(from.getTime(), to.getTime()));
        Printer.printCollection(controller.getCompletedOrderSortedByPrice(from.getTime(), to.getTime()));

        System.out.println(controller.getIncome(from.getTime(), to.getTime()));

        Printer.printCollection(controller.getCompletedOrder(from.getTime(), to.getTime()));

        Printer.printCollection(controller.getStaleBooksDate(from.getTime()));
        Printer.printCollection(controller.getStaleBooksPrice(from.getTime()));

//        System.out.println(controller.getOrderDetails(1));
//        System.out.println(controller.getBookDescription("x"));

//        controller.setBookQuantity("x", 10);

        List<Book> bookList = new ArrayList<>();
//        bookList.add( controller.GetBookByName("x"));
//        bookList.add( controller.GetBookByName("c"));

        controller.addOrder(bookList , 10);

//        controller.assembleOrder(controller.getOrderById(1));

//        controller.cancelTheOrder(controller.getOrderById(1));

//        controller.addRequest(controller.GetBookByName("x"));

        controller.writeToFile(path);
    }

    public static void testCreate(String path){
        Calendar calendar =Calendar.getInstance();
        IController controller = new Controller();

        ArrayList<Book> books = new ArrayList<>();
        calendar.set(2017, Calendar.FEBRUARY, 1);
        books.add(new Book("x", new Date(), calendar.getTime(), (float)151.12, 1));
        calendar.set(2017, Calendar.FEBRUARY, 3);
        books.add(new Book("a",  new Date(), calendar.getTime(), (float)90, 0));
        calendar.set(2017,  Calendar.FEBRUARY, 4);
        books.add(new Book("b", new Date(), calendar.getTime(), (float)151, 11));
        calendar.set(2017, Calendar.SEPTEMBER, 5);
        books.add(new Book("c", new Date(), calendar.getTime(), (float)40.5, 3));

        ArrayList<Request> requests = new ArrayList<>();
        requests.add(new Request("x", 1));
        requests.add(new Request("c", 4));
        requests.add(new Request("a", 2));
        requests.add(new Request("b", 0));

        ArrayList<Order> orders = new ArrayList<>();
        calendar.set(2017, Calendar.FEBRUARY, 1);
        orders.add(new Order(1, (float)50, calendar.getTime(), "transit", Order.Status.PROCESSED, false));
        calendar.set(2017, Calendar.APRIL, 1);
        orders.add(new Order(2, (float)40, calendar.getTime(), "transit", Order.Status.PROCESSED, false));
        calendar.set(2017, Calendar.MARCH, 1);
        orders.add(new Order(3, (float)40, calendar.getTime(), "transit", Order.Status.PROCESSED, false));
        calendar.set(2017, Calendar.OCTOBER, 1);
        orders.add(new Order(4, (float)150, calendar.getTime(), "delivery", Order.Status.PROCESSED, true));

        BookStore bookStore = new BookStore();
        bookStore.setBookList(books);
        controller.setBookStore(bookStore);
        OrderStore orderStore = new OrderStore();
        orderStore.setOrderArrayList(orders);
        controller.setOrderStore(orderStore);
        RequestStore requestStore = new RequestStore();
        requestStore.setRequestArrayList(requests);
        controller.setRequestStore(requestStore);

        controller.writeToFile(path);

    }



}
