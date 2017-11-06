package com.senla.booksshop.stores;

import com.senla.booksshop.model.Book;

import java.io.Serializable;
import java.util.List;

public interface IBookStore extends Serializable {
    List<Book> getBookList();

    void setBookList(List<Book> bookList);

    void create();

    void read();

    void update();

    void delete();
}
