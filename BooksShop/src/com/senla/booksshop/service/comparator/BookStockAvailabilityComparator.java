package com.senla.booksshop.service.comparator;

import com.senla.api.model.Book;

import java.util.Comparator;

public class BookStockAvailabilityComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if(o1 == null || o2 == null)
        {
            return NullCompareFoComparators.compare(o1,o2);
        }
        if (o1.getInStock() > o2.getInStock()){
            return 1;
        }
        if (o1.getInStock()< o2.getInStock()){
            return -1;
        }
        return 0;
    }
}
