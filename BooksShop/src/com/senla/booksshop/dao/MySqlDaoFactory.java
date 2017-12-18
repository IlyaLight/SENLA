package com.senla.booksshop.dao;

import com.senla.api.model.Book;
import com.senla.api.model.Order;

import java.util.HashMap;
import java.util.Map;

public class MySqlDaoFactory implements DaoFactory {

    private static Map<Class, DaoCreator> creators;

    @Override
    public GenericDao getDao( Class dtoClass) {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new RuntimeException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create();
    }

    public MySqlDaoFactory() {
        creators = new HashMap<>();
        creators.put(Book.class, MySqlBookDao::new);
        creators.put(Order.class, MySqlOrderDao::new);
    }
}
