package com.senla.booksshop.dao.api;

import com.senla.api.model.Book;

import java.util.Date;
import java.util.List;

public interface IBookDao {

    public static final String ID               = "id";
    public static final String NAME             = "name";
    public static final String DATE_PUBLICATION = "date_publication";
    public static final String DATE_ISSUE       = "date_issue";
    public static final String PRICE            = "price";
    public static final String IN_STOCK         = "in_stock";
    public static final String TABLE            = "book";

    List<Book> getStaleBooks(Date data, String columnName);

    List<Book> booksReceivedLaterThan(Date data, String columnName);

    List<Book> getAll(String... sortingColumn);

    void create(Book t);

    Book getByPK(int key);

    void  update(Book t);

    void delete(Book t);



}
