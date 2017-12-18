package com.senla.booksshop.dao;

public interface DaoFactory {

     interface DaoCreator {
         GenericDao create();
    }

        GenericDao getDao(Class dtoClass);
}