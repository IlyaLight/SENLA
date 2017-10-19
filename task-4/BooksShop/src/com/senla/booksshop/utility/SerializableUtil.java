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

    private static Logger log = Logger.getLogger(WorkWithFile.class.getName());

    public static void exportBook(String path){
        exportObject(Model.BOOKS, path);
    }

    public static void exportOrder(String path){
        exportObject(Model.ORDER, path);
    }

    public static void exportRequest(String path){
        exportObject(Model.REQUEST, path);
    }

    private static void exportObject(Model model, String path){
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
            oos.flush();
            oos.close();
        } catch (IOException e){
        log.log(Level.SEVERE, EXCEPTION, e);
        throw new RuntimeException(e);
        }
    }


    public static BookStore importBooks(String path){
        return (BookStore)importObject(path);
    }

    public static RequestStore importRequest(String path){
        return (RequestStore)importObject(path);
    }

    public static OrderStore importOrder(String path){
        return (OrderStore)importObject(path);
    }

    private static Object importObject(String path){
        try {
            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            Object object = oin.readObject();
            oin.close();
            return object;
        } catch (IOException | ClassNotFoundException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
