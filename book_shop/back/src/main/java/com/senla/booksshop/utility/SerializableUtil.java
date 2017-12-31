package com.senla.booksshop.utility;

import com.senla.booksshop.stores.IBookStore;
import com.senla.booksshop.stores.IOrderStore;
import com.senla.booksshop.stores.IRequestStore;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SerializableUtil {

    private enum Model{BOOKS, ORDER, REQUEST}

    private static final String BOOKS_FILE_NAME = "booksSerializable.txt";
    private static final String ORDER_FILE_NAME = "ordersSerializable.txt";
    private static final String REQUEST_FILE_NAME = "requestsSerializable.txt";
    private static final String EXCEPTION = "Exception: ";

    private static final Logger log = Logger.getLogger(SerializableUtil.class.getName());

    public static void writeBook(IBookStore IBookStore, String path){
        writeObject(IBookStore, path + BOOKS_FILE_NAME);
    }

    public static void writeOrder(IOrderStore IOrderStore, String path){
        writeObject(IOrderStore, path + ORDER_FILE_NAME);
    }

    public static void writeRequest(IRequestStore IRequestStore, String path){
        writeObject(IRequestStore, path + REQUEST_FILE_NAME);
    }

    private static <T> void writeObject(T t, String path){
        try (ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(path))){
            oos.writeObject(t);
            oos.flush();
        } catch (IOException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }


    public static IBookStore readBooks(String path){
        return (IBookStore) readObject(path + BOOKS_FILE_NAME);
    }

    public static IRequestStore readRequest(String path){
        return (IRequestStore) readObject(path + REQUEST_FILE_NAME);
    }

    public static IOrderStore readOrder(String path){
        return (IOrderStore) readObject(path + ORDER_FILE_NAME);
    }

    private static Object readObject(String path){
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(path))){
            Object object = oin.readObject();
            return object;
        } catch (IOException | ClassNotFoundException e){
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }

}
