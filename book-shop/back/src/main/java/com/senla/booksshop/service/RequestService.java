package com.senla.booksshop.service;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.api.IRequestDao;
import dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestService implements IRequestService {


    @Injection
    private IRequestDao requestDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestService.class);

    @Override
    public List<Request> getAll(){
        return requestDao.getAll(IRequestDao.BOOK_ID);
    }

    @Override
    public List<Request> getRequestSortedOfQuantity() {
        return requestDao.getAll(IRequestDao.QUANTITY);
    }
}
