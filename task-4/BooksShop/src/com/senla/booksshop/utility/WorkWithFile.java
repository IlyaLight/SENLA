package com.senla.booksshop.utility;

import com.danco.training.TextFileWorker;
import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;

import java.util.ArrayList;
import java.util.Date;

public class WorkWithFile {

    private static final String BOOKS_FILE_NAME = "books.txt";
    private static final String ORDER_FILE_NAME = "orders.txt";
    private static final String REQUEST_FILE_NAME = "requests.txt";

    public static ArrayList<Book> readBooksFromFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + BOOKS_FILE_NAME);
        String[] strings = textFileWorker.readFromFile();
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (String string : strings) {
            String[] book = string.split(" ");
            bookList.add(new Book(book[0],
                    new Date(Long.decode(book[1])),
                    Float.parseFloat(book[2]),
                    Integer.parseInt(book[3])));
        }
        return bookList;
    }

    public static void writeBooksToFile(final String filePath, ArrayList<Book> bookList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + BOOKS_FILE_NAME);
        ArrayList<String> books = new ArrayList<String>();
        for (Book book : bookList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(book.getName() + " ");
            stringBuilder.append(book.getDateIssue().getTime() + " ");
            stringBuilder.append(book.getPrice() + " ");
            stringBuilder.append(book.getInStock());
            books.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(books.toArray(new String[books.size()]));
    }

    public static ArrayList<Order> readOrdersFromFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + ORDER_FILE_NAME);
        String[] strings = textFileWorker.readFromFile();
        ArrayList<Order> orderArrayList = new ArrayList<Order>();
        for (String string : strings) {
            String[] order = string.split(" ");
            orderArrayList.add(new Order(order[0],
                    Float.parseFloat(order[1]),
                    new Date(Long.decode(order[2])),
                    order[3],
                    Boolean.parseBoolean(order[4])));
        }
        return orderArrayList;
    }

    public static void writeOrdersToFile(final String filePath, ArrayList<Order> orderArrayList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + ORDER_FILE_NAME);
        ArrayList<String> orders = new ArrayList<String>();
        for (Order order : orderArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.getBookName() + " ");
            stringBuilder.append(order.getPrice() + " ");
            stringBuilder.append(order.getDataCompletion().getTime() + " ");
            stringBuilder.append(order.getStatus() + " ");
            stringBuilder.append(order.isCompleted());
            orders.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }

    public static ArrayList<Request> readRequestFromFile(final String filePath){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + REQUEST_FILE_NAME);
        String[] strings = textFileWorker.readFromFile();
        ArrayList<Request> requestArrayList = new ArrayList<Request>();
        for (String string : strings) {
            String[] order = string.split(" ");
            requestArrayList.add(new Request(order[0],
                    Boolean.parseBoolean(order[1])));
        }
        return requestArrayList;
    }

    public static void writeRequestsToFile(final String filePath, ArrayList<Request> requestArrayList){
        TextFileWorker textFileWorker = new TextFileWorker(filePath + REQUEST_FILE_NAME);
        ArrayList<String> orders = new ArrayList<String>();
        for (Request order : requestArrayList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(order.getBookName() + " "
                    + order.isCompleted());
            orders.add(stringBuilder.toString());
        }
        textFileWorker.writeToFile(orders.toArray(new String[orders.size()]));
    }



}
