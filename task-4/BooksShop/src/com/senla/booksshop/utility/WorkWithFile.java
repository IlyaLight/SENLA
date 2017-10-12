package com.senla.booksshop.utility;

import com.danco.training.TextFileWorker;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkWithFile {

    private static Logger log = Logger.getLogger(WorkWithFile.class.getName());

    private static final String BOOKS_FILE_NAME = "books.txt";
    private static final String ORDER_FILE_NAME = "orders.txt";
    private static final String REQUEST_FILE_NAME = "requests.txt";

    public static List<Book> readBooksFromFile(final String filePath){
        try {
            TextFileWorker textFileWorker = new TextFileWorker(filePath + BOOKS_FILE_NAME);
            String[] strings = textFileWorker.readFromFile();
            List<Book> bookList = new ArrayList<>();
            for (String string : strings) {
                String[] book = string.split(" ");
                bookList.add(new Book(book[0],
                        new Date(Long.decode(book[1])),
                        new Date(Long.decode(book[2])),
                        Float.parseFloat(book[3]),
                        Integer.parseInt(book[4])));
            }
            return bookList;
        }catch (IllegalArgumentException e){
            IllegalArgumentException exception = new IllegalArgumentException(filePath + BOOKS_FILE_NAME + "  not found");
            log.log(Level.INFO, "IllegalArgumentException: ", exception);
            throw exception;
        }
    }

    public static void writeBooksToFile(final String filePath, List<Book> bookList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + BOOKS_FILE_NAME);
        ArrayList<String> books = new ArrayList<>();
        for (Book book : bookList) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append(book.getName()).append(" ")
                    .append(book.getDateIssue().getTime()).append(" ")
                    .append(book.getDatePublication().getTime()).append(" ")
                    .append(book.getPrice()).append(" ")
                    .append(book.getInStock());
            books.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(books.toArray(new String[books.size()]));
    }

    public static List<Order> readOrdersFromFile(final String filePath){
//        try {
            TextFileWorker textFileWorker = new TextFileWorker(filePath + ORDER_FILE_NAME);
            String[] strings = textFileWorker.readFromFile();
            List<Order> orderArrayList = new ArrayList<Order>();
            for (String string : strings) {
                String[] order = string.split(" ");
                orderArrayList.add(new Order(Integer.parseInt(order[0]),
                        Float.parseFloat(order[1]),
                        new Date(Long.decode(order[2])),
                        order[3],
                        Order.Status.valueOf(order[4]),
                        Boolean.parseBoolean(order[5])));
            }
            return orderArrayList;
//        }catch (IllegalArgumentException e){
//            IllegalArgumentException exception = new IllegalArgumentException(filePath + ORDER_FILE_NAME + "  not found");
//            log.log(Level.INFO, "IllegalArgumentException: ", exception);
//            throw exception;
//        }

    }

    public static void writeOrdersToFile(final String filePath, List<Order> orderArrayList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + ORDER_FILE_NAME);
        ArrayList<String> orders = new ArrayList<String>();
        for (Order order : orderArrayList) {
            StringBuilder stringBuilder = new StringBuilder()
                    .append(order.getId()).append(" ")
                    .append(order.getPrice()).append(" ")
                    .append(order.getDataCompletion().getTime()).append(" ")
                    .append(order.getDetails()).append(" ")
                    .append(order.getStatus()).append(" ")
                    .append(order.isCompleted());
            orders.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }

    public static ArrayList<Request> readRequestFromFile(final String filePath){
        try {
            TextFileWorker textFileWorker = new TextFileWorker(filePath + REQUEST_FILE_NAME);
        String[] strings = textFileWorker.readFromFile();
        ArrayList<Request> requestArrayList = new ArrayList<Request>();
        for (String string : strings) {
            String[] order = string.split(" ");
            requestArrayList.add(new Request(order[0],
                   Integer.parseInt(order[1])));
        }
        return requestArrayList;
        }catch (IllegalArgumentException e){
            IllegalArgumentException exception = new IllegalArgumentException(filePath + REQUEST_FILE_NAME + "  not found");
            log.log(Level.INFO, "IllegalArgumentException: ", exception);
            throw exception;
        }
    }

    public static void writeRequestsToFile(final String filePath, List<Request> requestArrayList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + REQUEST_FILE_NAME);
        List<String> orders = new ArrayList<String>();
        for (Request order : requestArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.getBookName() + " "
                    + order.getQuantity());
            orders.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }

    public static void createFiles(String filePath){
        Path filePathBook = Paths.get(filePath + BOOKS_FILE_NAME);
        Path filePathOrder = Paths.get(filePath + ORDER_FILE_NAME);
        Path filePathRequest = Paths.get(filePath + REQUEST_FILE_NAME);
        try {
            Files.createFile(filePathBook);
            Files.createFile(filePathOrder);
            Files.createFile(filePathRequest);
        }   catch (IOException x){x.printStackTrace();}
    }

}
