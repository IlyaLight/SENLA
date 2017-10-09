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
import com.senla.booksshop.utility.WorkWithFile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Main {

    static final String  STANDART_PATH = "e:/OneDrive/Project/SENLA/task-4/BooksShop/out/artifacts/BooksShop_jar/";

    public static void main(String[] args) throws Exception{

        System.out.println("Book_Shop");
        String path = STANDART_PATH;
        if (args.length > 0) {
            System.out.println("args0 = " + args[0]);
            path = args[0];
        }

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

        Printer.printCollection(controller.getOrderSortedByDataComplection());
        Printer.printCollection(controller.getOrderSortedByPrice());
        Printer.printCollection(controller.getOrderSortedByStatus());

        Printer.printCollection(controller.getRequstSortedOfquantity());
        Printer.printCollection(controller.getRequstSortedByBookName());

        Printer.printCollection(controller.getCompletedOrderSortedByCompletedData(from.getTime(), to.getTime()));
        Printer.printCollection(controller.getCompletedOrderSortedByPrice(from.getTime(), to.getTime()));

        System.out.println(controller.getIncome(from.getTime(), to.getTime()));

        Printer.printCollection(controller.getCompletedOrder(from.getTime(), to.getTime()));

        Printer.printCollection(controller.getStaleBooksDate(from.getTime()));
        Printer.printCollection(controller.getStaleBooksPrice(from.getTime()));

        System.out.println(controller.getOrderDetails(1));
        System.out.println(controller.getBookDescription("x"));

        controller.setBookAsQuantity("x", 10);

        List<Book> bookList = new ArrayList<>();
        bookList.add( controller.findBookByName("x"));
        bookList.add( controller.findBookByName("c"));

        controller.addOrder(bookList , 10);

        controller.assembledAnOrder(controller.getOrderByIp(1));

        controller.cancelTheOrder(controller.getOrderByIp(1));

        controller.addRequst(controller.findBookByName("x"));

        controller.writeToFile(path);
    }

    public static void testCreate(String path){
        WorkWithFile.createFiles(path);
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
        orders.add(new Order(1, (float)50, calendar.getTime(), "transit", Order.Status.КОМПЛЕКТУЕТСЯ, false));
        calendar.set(2017, Calendar.APRIL, 1);
        orders.add(new Order(2, (float)40, calendar.getTime(), "transit", Order.Status.КОМПЛЕКТУЕТСЯ, false));
        calendar.set(2017, Calendar.MARCH, 1);
        orders.add(new Order(3, (float)40, calendar.getTime(), "transit", Order.Status.КОМПЛЕКТУЕТСЯ, false));
        calendar.set(2017, Calendar.OCTOBER, 1);
        orders.add(new Order(4, (float)150, calendar.getTime(), "delivery", Order.Status.КОМПЛЕКТУЕТСЯ, true));

        BookStore bookStore = new BookStore();
        controller.setBookStore(bookStore);
        OrderStore orderStore = new OrderStore();
        controller.setOrderStore(orderStore);
        RequestStore requestStore = new RequestStore();
        controller.setRequestStore(requestStore);

        controller.writeToFile(path);

    }



}
