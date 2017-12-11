package com.senla.booksshop.dao;

public class PersistException extends Exception {
    
    public PersistException(String massage){
        super(massage);
    }

    public PersistException(Exception e){
        super(e);
    }
}
