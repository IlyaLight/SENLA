package com.senla.booksshop.service;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.service.comparator.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
public class BookService {

    private static final BookNameComparator BOOK_NAME_COMPARATOR = new BookNameComparator();
    private static final BookPriceComparator BOOK_PRICE_COMPARATOR = new BookPriceComparator();
    private static final BookDateIssueComparator BOOK_DATE_ISSUE_COMPARATOR = new BookDateIssueComparator();
    private static final BookStockAvailabilityComparator BOOK_STOCK_AVAILABILITY_COMPARATOR =
            new BookStockAvailabilityComparator();
    private static final BookDatePublicationComparator BOOK_DATE_PUBLICATION_COMPARATOR =
            new BookDatePublicationComparator();


    public static List<Book> getBooksSortedByName(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<>(bookArrayList);
        books.sort(BOOK_NAME_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByPrice(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<>(bookArrayList);
        books.sort(BOOK_PRICE_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByDateIssue(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<>(bookArrayList);
        books.sort(BOOK_DATE_ISSUE_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByStockAvailability(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<>(bookArrayList);
        books.sort(BOOK_STOCK_AVAILABILITY_COMPARATOR);
        return books;
    }

    public static List<Book> getBookSortedByDatePublication(List<Book> bookArrayList){
        List<Book> books = new ArrayList<>(bookArrayList);
        books.sort(BOOK_DATE_PUBLICATION_COMPARATOR);
        return books;
    }

    public static List<Book> getStaleBooksDate(List<Book> bookArrayList, Date date){
        List<Book> books = booksReceivedLaterThan(bookArrayList, date);
        return getBookSortedByDatePublication(books);
    }

    public static List<Book> getStaleBooksPrice(List<Book> bookArrayList, Date date){
        List<Book> books = booksReceivedLaterThan(bookArrayList, date);
        return getBooksSortedByPrice(books);
    }

    private static List<Book> booksReceivedLaterThan(List<Book> bookArrayList, Date date){
        List<Book> books = new ArrayList<>(bookArrayList);
        for (Book book : bookArrayList){
            if (book.getDatePublication().getTime() <= date.getTime()){
                books.add(book);
            }
        }
        return books;
    }

    public static String getBookDescription(List<Book> bookList, String nameBook){
        for (Book book : bookList) {
            if (book.getName().equals(nameBook)){
                return book.getDescription();
            }
        }
        return null;
    }

    public static Book getBookById(List<Book> bookList, int id){
        for (Book book : bookList) {
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }
}
