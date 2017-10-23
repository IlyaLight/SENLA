package com.senla.booksshop.utility;

import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.OrderStore;
import com.senla.booksshop.stores.RequestStore;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SerializableUtil {

    private enum Model{BOOKS, ORDER, REQUEST}

    private static final String BOOKS_FILE_NAME = "books.out";
    private static final String ORDER_FILE_NAME = "orders.out";
    private static final String REQUEST_FILE_NAME = "requests.out";
    private static final String EXCEPTION = "Exception: ";

    private static final Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public static void writeBook(BookStore bookStore, String path){
        writeObject(Model.BOOKS,bookStore, path);
    }

    public static void writeOrder(OrderStore orderStore, String path){
        writeObject(Model.ORDER,orderStore, path);
    }

    public static void writeRequest(RequestStore requestStore, String path){
        writeObject(Model.REQUEST,requestStore, path);
    }

    private static void writeObject(Model model, Object object, String path){
        FileOutputStream fos;
        try {
            if (model == Model.BOOKS) {
                fos = new FileOutputStream(path + BOOKS_FILE_NAME);
            }else if (model == Model.REQUEST){
                fos = new FileOutputStream(path + REQUEST_FILE_NAME);
            } else if (model == Model.ORDER){
                fos = new FileOutputStream(path + ORDER_FILE_NAME);
            } else {
                throw new IOException();
            }
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e){
        log.log(Level.SEVERE, EXCEPTION, e);
        throw new RuntimeException(e);
        }
    }


    public static BookStore readtBooks(String path){
        return (BookStore) readObject(path);
    }

    public static RequestStore readRequest(String path){
        return (RequestStore) readObject(path);
    }

    public static OrderStore readOrder(String path){
        return (OrderStore) readObject(path);
    }

    private static Object readObject(String path){
        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Object object = oin.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
