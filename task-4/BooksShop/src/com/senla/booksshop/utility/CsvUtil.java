package com.senla.booksshop.utility;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.model.Order;
import com.senla.booksshop.model.Request;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CsvUtil {

    private static final Logger log = Logger.getLogger(CsvUtil.class.getName());

    private static final String EXCEPTION = "Exception:";

    private static final String BOOKS_FILE_NAME = "books.csv";
    private static final String ORDER_FILE_NAME = "orders.csv";
    private static final String REQUEST_FILE_NAME = "requests.csv";

    private static final String[] bookHeader = new String[] {"id","name","datePublication","dateIssue","price","inStock"};
    private static final String[] ordersHeader = new String[] {"id","price","dataCompletion","details","status","completed"};
    private static final String[] requestsHeader = new String[] {"id","bookName","quantity"};

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String TRUE_VALUE = "Y";
    private static final String FALSE_VALUE = "N";

    private static final CellProcessor[] bookProcessorsExp = new CellProcessor[]{
            new NotNull(),  //id
            new NotNull(),  //name
            new FmtDate(DATE_FORMAT), // dateIssue
            new FmtDate(DATE_FORMAT), // datePublication
            new NotNull(),  //price
            new Optional(), //inStock
    };

    private static final CellProcessor[] bookProcessorsImp = new CellProcessor[] {
            new ParseInt(),  //id
            new NotNull(),  //name
            new ParseDate(DATE_FORMAT), // dateIssue
            new ParseDate(DATE_FORMAT), // datePublication
            new ParseDouble(),  //price
            new ParseInt(), //inStock
    };

    private static final CellProcessor[] orderProcessorsExp = new CellProcessor[] {
            new NotNull(),  //id
            new NotNull(),  //price
            new Optional(new FmtDate(DATE_FORMAT)), // dataCompletion
            new Optional(),  //details
            new NotNull(), // status
            new FmtBool(TRUE_VALUE, FALSE_VALUE), //completed
    };

    private static final CellProcessor[] orderProcessorsImp = new CellProcessor[] {
            new ParseInt(),     //id
            new ParseDouble(),  //price
            new Optional(new ParseDate(DATE_FORMAT)), // dataCompletion
            new Optional(),     //details
            new ParseEnum(Order.Status.class), // status
            new ParseBool(TRUE_VALUE, FALSE_VALUE), //completed
    };

    private static final CellProcessor[] requestProcessorsExp = new CellProcessor[] {
            new NotNull(),  //id
            new NotNull(),  //bookName
            new NotNull(),  //quantity
    };

    private static final CellProcessor[] requestProcessorsImp = new CellProcessor[] {
            new ParseInt(),  //id
            new NotNull(),  //bookName
            new ParseInt(),  //quantity
    };

    public static void exportBooks(List<Book> bookList, String path){
        exportObject(bookList, bookProcessorsExp, bookHeader,path + BOOKS_FILE_NAME);
    }

    public static void exportOrders(List<Order> orderList, String path){
        exportObject(orderList, orderProcessorsExp, ordersHeader, path + ORDER_FILE_NAME);
    }

    public static void exportRequests(List<Request> requestList, String path){
        exportObject(requestList, requestProcessorsExp, requestsHeader, path + REQUEST_FILE_NAME);
    }

    private static <E> void exportObject( List<E> list, CellProcessor[] processor, String[] header, String path){
        try (ICsvBeanWriter beanWriter = new CsvBeanWriter(new FileWriter(path), CsvPreference.STANDARD_PREFERENCE)){
            beanWriter.writeHeader(header);
            for (E e : list) {
                beanWriter.write(e, header, processor);
            }
        }catch (IOException e){
           log.log(Level.SEVERE, EXCEPTION, e);
           throw new RuntimeException(e);
        }
    }

    public static List<Book> importBooks(String path){
        return importObjectList( Book.class, bookProcessorsImp, path + BOOKS_FILE_NAME);
    }

    public static List<Order> importOrder(String path){
        return importObjectList(Order.class, orderProcessorsImp, path + ORDER_FILE_NAME);
    }

    public static List<Request> importRequest(String path){
        return  importObjectList(Request.class, requestProcessorsImp, path + REQUEST_FILE_NAME);
    }

    private static <T> List<T> importObjectList(Class<T> tClass, CellProcessor[] processor, String path) {
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(path), CsvPreference.STANDARD_PREFERENCE)) {
            String[] header = beanReader.getHeader(true);
            List<T> tList = new ArrayList<>();
            T t;
            while ((t = beanReader.read(tClass, header, processor)) != null) {
                tList.add(t);
            }
            return tList;
        } catch (IOException e) {
            log.log(Level.SEVERE, EXCEPTION, e);
            throw new RuntimeException(e);
        }
    }
}
