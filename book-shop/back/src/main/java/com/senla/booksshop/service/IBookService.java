package com.senla.booksshop.service;

import com.senla.api.model.Book;

import java.util.Date;
import java.util.List;

public interface IBookService {
    String WHERE_DATE_PUBLICATION = " WHERE date_publication > ";

    List<Book> getBooksSortedByName();

    List<Book> getBooksSortedByPrice();

    List<Book> getBooksSortedByDateIssue();

    List<Book> getBooksSortedByStockAvailability();

    List<Book> getBookSortedByDatePublication();

    List<Book> getStaleBooksDate(Date date);

    List<Book> getStaleBooksPrice(Date date);

    String getBookDescription(int bookId);

    Book getBookById(int bookId);

    List<Book> getBookList();
}
