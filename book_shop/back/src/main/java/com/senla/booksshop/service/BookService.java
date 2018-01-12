package com.senla.booksshop.service;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import com.senla.booksshop.dao.realization.jdbc.MySqlBookDao;
import com.senla.booksshop.stores.IBookStore;
import dependencyinjection.annotation.Injection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
public class BookService {

    private static final String BY_NAME_ASC = " ORDER BY name ASC;";

    private static final String WHERE_DATE_ISSUE = " WHERE date_issue > ";
    private static final String ORDER_BY_DATE_PUBLICATION_ASC1 = " ORDER BY date_publication ASC;";
    private static final String ORDER_BY_PRICE_ASC = " ORDER BY price ASC;";
    public static final String WHERE_DATE_PUBLICATION = " WHERE date_publication > ";
    private static final String ERROR = "Error:";

    private static final SimpleDateFormat dateFormat = new  SimpleDateFormat("'yyyy-MM-dd'");

    @Injection
    private IBookStore bookStore;
    @Injection
    private IBookDao bookDao;

    public List<Book> getBooksSortedByName() {
        return bookDao.getAll(MySqlBookDao.NAME);
    }

    public List<Book> getBooksSortedByPrice() {
        return bookDao.getAll(MySqlBookDao.PRICE);
    }

    public  List<Book> getBooksSortedByDateIssue() {
        return bookDao.getAll(MySqlBookDao.DATE_ISSUE);
}

    public  List<Book> getBooksSortedByStockAvailability() {
        return bookDao.getAll(MySqlBookDao.IN_STOCK);
    }

    public  List<Book> getBookSortedByDatePublication(){
        return bookDao.getAll(MySqlBookDao.DATE_PUBLICATION);
    }

    public  List<Book> getStaleBooksDate(Date date){
        return bookDao.getStaleBooks(date, MySqlBookDao.DATE_ISSUE);
    }

    public List<Book> getStaleBooksPrice(Date date){
        return bookDao.getStaleBooks(date, MySqlBookDao.PRICE);
    }

    private List<Book> booksReceivedLaterThan(Date date){
        return bookDao.booksReceivedLaterThan(date, MySqlBookDao.NAME);
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
