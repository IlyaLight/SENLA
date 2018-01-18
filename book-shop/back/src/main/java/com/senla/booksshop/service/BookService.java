package com.senla.booksshop.service;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import dependencyinjection.annotation.Injection;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
    public class BookService implements IBookService {

    private static final String BY_NAME_ASC = " ORDER BY name ASC;";

    private static final String WHERE_DATE_ISSUE = " WHERE date_issue > ";
    private static final String ORDER_BY_DATE_PUBLICATION_ASC1 = " ORDER BY date_publication ASC;";
    private static final String ORDER_BY_PRICE_ASC = " ORDER BY price ASC;";
    private static final String ERROR = "Error:";

    private static final SimpleDateFormat dateFormat = new  SimpleDateFormat("'yyyy-MM-dd'");

    @Injection
    private IBookDao bookDao;

    @Override
    public List<Book> getBooksSortedByName() {
        return bookDao.getAll(IBookDao.NAME);
    }

    @Override
    public List<Book> getBooksSortedByPrice() {
        return bookDao.getAll(IBookDao.PRICE);
    }

    @Override
    public  List<Book> getBooksSortedByDateIssue() {
        return bookDao.getAll(IBookDao.DATE_ISSUE);
}

    @Override
    public  List<Book> getBooksSortedByStockAvailability() {
        return bookDao.getAll(IBookDao.IN_STOCK);
    }

    @Override
    public  List<Book> getBookSortedByDatePublication(){
        return bookDao.getAll(IBookDao.DATE_PUBLICATION);
    }

    @Override
    public  List<Book> getStaleBooksDate(Date date){
        return bookDao.getStaleBooks(date, IBookDao.DATE_ISSUE);
    }

    @Override
    public List<Book> getStaleBooksPrice(Date date){
        return bookDao.getStaleBooks(date, IBookDao.PRICE);
    }

    private List<Book> booksReceivedLaterThan(Date date){
        return bookDao.booksReceivedLaterThan(date, IBookDao.NAME);
    }

    @Override
    public String getBookDescription(int bookId){
        Book book = bookStore.read(bookId);
        if (book == null){
            return null;
        }
        return book.getDescription();
    }

    @Override
    public Book getBookById(int bookId){
        return bookStore.read(bookId);
    }
}
