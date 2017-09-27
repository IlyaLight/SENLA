package com.senla.booksshop.sorted;

import com.senla.booksshop.objekt.Book;

import java.util.Comparator;

class BookDateIssueComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getDateIssue().compareTo(o2.getDateIssue());
    }
}
