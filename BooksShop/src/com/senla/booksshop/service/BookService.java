package com.senla.booksshop.service;

import com.senla.api.model.Book;
import com.senla.booksshop.stores.IBookStore;
import com.senla.dependencyinjection.annotation.Injection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
public class BookService {

    private static final String BY_NAME_ASC = " ORDER BY name ASC;";
    private static final String BY_PRICE_ASC = " ORDER BY price ASC;";
    private static final String BY_DATE_ISSUE_ASC = " ORDER BY date_issue ASC;";
    private static final String ORDER_BY_IN_STOCK_ASC = " ORDER BY in_stock ASC;";
    private static final String ORDER_BY_DATE_PUBLICATION_ASC = " ORDER BY date_publication ASC;";
    private static final String WHERE_DATE_ISSUE = " WHERE date_issue > ";
    private static final String ORDER_BY_DATE_PUBLICATION_ASC1 = " ORDER BY date_publication ASC;";
    private static final String ORDER_BY_PRICE_ASC = " ORDER BY price ASC;";
    public static final String WHERE_DATE_PUBLICATION = " WHERE date_publication > ";
    private static final String ERROR = "Error:";

    private static final SimpleDateFormat dateFormat = new  SimpleDateFormat("'yyyy-MM-dd'");

    @Injection
    private IBookStore bookStore;

    public List<Book> getBooksSortedByName() {
        return bookStore.getBooks(BY_NAME_ASC);
    }

    public List<Book> getBooksSortedByPrice() {
        return bookStore.getBooks(BY_PRICE_ASC);
    }

    public  List<Book> getBooksSortedByDateIssue() {
        return bookStore.getBooks(BY_DATE_ISSUE_ASC);
    }

    public  List<Book> getBooksSortedByStockAvailability() {
        return bookStore.getBooks(ORDER_BY_IN_STOCK_ASC);
    }

    public  List<Book> getBookSortedByDatePublication(){
        return bookStore.getBooks(ORDER_BY_DATE_PUBLICATION_ASC);
    }

    public  List<Book> getStaleBooksDate(Date date){
        return bookStore.getBooks(WHERE_DATE_ISSUE + dateFormat.format(date) + ORDER_BY_DATE_PUBLICATION_ASC1);
    }

    public List<Book> getStaleBooksPrice(Date date){
        return bookStore.getBooks(WHERE_DATE_ISSUE + dateFormat.format(date) + ORDER_BY_PRICE_ASC);
    }

    private List<Book> booksReceivedLaterThan(Date date){
        return bookStore.getBooks(WHERE_DATE_PUBLICATION + dateFormat.format(date) + BY_NAME_ASC);
    }

    public String getBookDescription(int bookId){
        Book book = bookStore.read(bookId);
        if (book == null){
            return null;
        }
        return book.getDescription();
    }

    public Book getBookById(int bookId){
        return bookStore.read(bookId);
    }
}
