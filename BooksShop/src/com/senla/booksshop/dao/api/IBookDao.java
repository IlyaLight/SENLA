package com.senla.booksshop.dao.api;

import com.senla.api.model.Book;

import java.util.Date;
import java.util.List;

public interface IBookDao {

    List<Book> getStaleBooks(Date data, String columnName);

    List<Book> booksReceivedLaterThan(Date data, String columnName);

    List<Book> getAll( String... sortingColumn);

    void create(Book t);

    Book getByPK(int key);

    void  update(Book t);

    void delete(Book t);



}
