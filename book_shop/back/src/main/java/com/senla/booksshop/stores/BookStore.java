package com.senla.booksshop.stores;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class BookStore implements IBookStore {

    private static final String ERROR = "Error:";

    private static final long serialVersionUID = -6727105669857102873L;
    private List<Book> bookList = new ArrayList<>();
    @Injection
    private IBookDao bookDao;

    public BookStore(List<Book> bookList) {
        this.bookList = bookList;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BookStore.class);

    public BookStore() {
    }

    @Override
    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void create(Book book) {
        bookDao.create(book);
    }

    @Override
    public Book read(Integer id) {
            return (Book) bookDao.getByPK(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(Book book)  {
        bookDao.delete(book);
    }



}
