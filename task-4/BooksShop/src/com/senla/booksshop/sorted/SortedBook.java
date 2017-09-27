package com.senla.booksshop.sorted;

import com.senla.booksshop.objekt.Book;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Light on 24.09.2017.
 */
public class SortedBook {

    private ArrayList<Book> bookArrayList;

    public SortedBook() {
    }

    public SortedBook(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    public void setBookArrayList(ArrayList<Book> bookArrayList) {
        this.bookArrayList = bookArrayList;
    }

    public TreeSet<Book> getBooksSortedByName() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookNameComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByPrice() {
        TreeSet<Book> treeSet = new TreeSet<Book>(new BookPriceComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByDateIssue() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookDateIssueComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }

    public TreeSet<Book> getBooksSortedByStockAvailability() {
        TreeSet<Book> treeSet = new TreeSet<>(new BookStockAvailabilityComparator());
        treeSet.addAll(bookArrayList);
        return treeSet;
    }
}
