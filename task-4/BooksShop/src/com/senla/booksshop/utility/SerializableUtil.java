package com.senla.booksshop.utility;

import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SerializableUtil {

    private enum Model{BOOKS, ORDER, REQUEST}

    private static final String BOOKS_FILE_NAME = "booksSerializable.txt";
    private static final String ORDER_FILE_NAME = "ordersSerializable.txt";
    private static final String REQUEST_FILE_NAME = "requestsSerializable.txt";
    private static final String EXCEPTION = "Exception: ";

    private static final Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public static void writeBook(BookStore bookStore, String path){
        writeObject(bookStore, path + BOOKS_FILE_NAME);
    }

    public static void writeOrder(OrderStore orderStore, String path){
        writeObject(orderStore, path + ORDER_FILE_NAME);
    }

    public static void writeRequest(RequestStore requestStore, String path){
        writeObject(requestStore, path + REQUEST_FILE_NAME);
    }

    private static <T> void writeObject(T t, String path){
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(t);
            oos.flush();
        } catch (IOException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }


    public static BookStore readBooks(String path){
        return (BookStore) readObject(path + BOOKS_FILE_NAME);
    }

    public static RequestStore readRequest(String path){
        return (RequestStore) readObject(path + REQUEST_FILE_NAME);
    }

    public static OrderStore readOrder(String path){
        return (OrderStore) readObject(path + ORDER_FILE_NAME);
    }

    private static Object readObject(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream oin = new ObjectInputStream(fis);
            Object object = oin.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
