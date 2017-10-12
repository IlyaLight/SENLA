package com.senla.booksshop.service.comparator;

import com.senla.booksshop.model.Book;

import java.util.Comparator;

public class BookDateIssueComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        return o1.getDateIssue().compareTo(o2.getDateIssue());
    }
}
