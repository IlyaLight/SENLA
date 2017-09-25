package com.senla.booksshop.Book;

import java.util.Comparator;

class BookNameComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
