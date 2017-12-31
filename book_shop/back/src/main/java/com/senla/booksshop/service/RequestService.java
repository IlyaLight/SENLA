package com.senla.booksshop.service;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.api.IRequestDao;
import com.senla.booksshop.dao.realization.MySqlRequestDao;
import com.senla.booksshop.stores.IRequestStore;
import com.senla.dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestService {

    @Injection
    private IRequestStore requestStore;
    @Injection
    private IRequestDao requestDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestService.class);

    public List<Request> getAll(){
        return requestDao.getAll(MySqlRequestDao.BOOK_ID);
    }

    public List<Request> getRequestSortedOfQuantity() {
        return requestDao.getAll(MySqlRequestDao.QUANTITY);
    }
}
