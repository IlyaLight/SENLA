package com.senla.booksshop.stores;

import com.senla.api.model.Book;

import java.io.Serializable;
import java.util.List;

public interface IBookStore extends Serializable {
    List<Book> getBookList();

    void setBookList(List<Book> bookList);

    void create(Book book);

    Book read(Integer id);

    void update(Book book);

    void delete(Book book);

}
