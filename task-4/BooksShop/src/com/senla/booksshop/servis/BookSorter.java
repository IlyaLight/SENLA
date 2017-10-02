package com.senla.booksshop.servis;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.servis.comparator.BookDateIssueComparator;
import com.senla.booksshop.servis.comparator.BookNameComparator;
import com.senla.booksshop.servis.comparator.BookPriceComparator;
import com.senla.booksshop.servis.comparator.BookStockAvailabilityComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
public class BookSorter {

    public static List<Book> getBooksSortedByName(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, new BookNameComparator());
        return books;
    }

    public static List<Book> getBooksSortedByPrice(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, new BookPriceComparator());
        return books;
    }

    public static List<Book> getBooksSortedByDateIssue(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, new BookDateIssueComparator());
        return books;
    }

    public static List<Book> getBooksSortedByStockAvailability(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, new BookStockAvailabilityComparator());
        return books;
    }
}
