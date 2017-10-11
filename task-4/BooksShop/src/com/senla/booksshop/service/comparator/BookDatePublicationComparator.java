package com.senla.booksshop.service.comparator;

import com.senla.booksshop.model.Book;

import java.util.Comparator;

public class BookDatePublicationComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getDatePublication().compareTo(o2.getDatePublication());
    }
}

