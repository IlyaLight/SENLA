package com.senla.booksshop.servis.comparator;

import com.senla.booksshop.model.Book;

import java.util.Comparator;

public class BookStockAvailabilityComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.getInStock() > o2.getInStock()){
            return 1;
        }
        if (o1.getInStock()< o2.getInStock()){
            return -1;
        }
        return 0;
    }
}
