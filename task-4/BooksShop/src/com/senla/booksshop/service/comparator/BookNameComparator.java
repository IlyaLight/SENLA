package com.senla.booksshop.service.comparator;

import com.senla.booksshop.model.Book;

import java.util.Comparator;

public class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
