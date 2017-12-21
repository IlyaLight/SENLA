package com.senla.booksshop.dao.api;

public interface IDaoFactory {

     interface DaoCreator {
         IGenericDao create();
    }

        IGenericDao getDao(Class dtoClass);
}