package com.senla.booksshop.Book;

import java.util.Comparator;

class BookStockAvailabilityComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        if (o1.isInStock() == true && o2.isInStock() == false ){
            return 1;
        }
        if (o1.isInStock() == false && o2.isInStock() == true ){
            return -1;
        }
        return 0;
    }
}
