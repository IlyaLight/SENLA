package com.senla.booksshop.servis;

import com.senla.booksshop.model.Book;
import com.senla.booksshop.servis.comparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * Created by Light on 24.09.2017.
 */
public class BookServis {

    public static final BookNameComparator BOOK_NAME_COMPARATOR = new BookNameComparator();
    public static final BookPriceComparator BOOK_PRICE_COMPARATOR = new BookPriceComparator();
    public static final BookDateIssueComparator BOOK_DATE_ISSUE_COMPARATOR = new BookDateIssueComparator();
    public static final BookStockAvailabilityComparator BOOK_STOCK_AVAILABILITY_COMPARATOR =
            new BookStockAvailabilityComparator();
    public static final BookDatePublicationComparator BOOK_DATE_PUBLICATION_COMPARATOR =
            new BookDatePublicationComparator();


    public static List<Book> getBooksSortedByName(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, BOOK_NAME_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByPrice(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, BOOK_PRICE_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByDateIssue(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, BOOK_DATE_ISSUE_COMPARATOR);
        return books;
    }

    public static List<Book> getBooksSortedByStockAvailability(List<Book> bookArrayList) {
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, BOOK_STOCK_AVAILABILITY_COMPARATOR);
        return books;
    }

    public static List<Book> getBookSortedByDatePublication(List<Book> bookArrayList){
        List<Book> books = new ArrayList<Book>(bookArrayList);
        Collections.sort(books, BOOK_DATE_PUBLICATION_COMPARATOR);
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
        List<Book> books = new ArrayList<Book>(bookArrayList);
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
        return "not found";
    }
}
