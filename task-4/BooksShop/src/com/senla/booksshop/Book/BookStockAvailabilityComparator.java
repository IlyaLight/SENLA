package com.senla.booksshop.Book;

import java.util.Comparator;

public class BookStockAvailabilityComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.isStockAvailability() == true && o2.isStockAvailability() == false ){
            return 1;
        }
        if (o1.isStockAvailability() == false && o2.isStockAvailability() == true ){
            return -1;
        }
        return 0;
    }
}
