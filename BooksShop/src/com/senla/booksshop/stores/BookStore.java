package com.senla.booksshop.stores;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.*;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import com.senla.dependencyinjection.annotation.Injection;
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
    private DaoFactory daoFactory;
    private GenericDao genericDao = daoFactory.getDao(this.getClass());

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
        try {
            genericDao.persist(book);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book read(Integer id) {
        try {
            return (Book)genericDao.getByPK(id);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Book book) {
        try {
            genericDao.update(book);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Book book)  {
        try {
            genericDao.delete(book);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getBooks(String options) {
        try {
            return genericDao.get(options);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

}
