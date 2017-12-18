package com.senla.booksshop.service;

import com.senla.api.model.Request;
import com.senla.booksshop.service.comparator.RequestBookNameComparator;
import com.senla.booksshop.service.comparator.RequestQuantityComparator;
import com.senla.booksshop.stores.BookStore;
import com.senla.booksshop.stores.IBookStore;
import com.senla.booksshop.stores.IRequestStore;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import com.senla.dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by Light on 24.09.2017.
 */
public class RequestService {

    private static final String ERROR = "Error:";

    private static final String BY_QUANTITY_ASC = "ORDER BY quantity ASC";
    private static final String INNER_JOIN_BOOK_ON_REQUEST_BOOK_ID_BOOK_ID = "INNER JOIN book ON request.book_id = book.id ORDER BY book.name";

    @Injection
    private IRequestStore requestStore;

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestService.class);

    public List<Request> getRequestSortedByBookName() {
            Connection connection = JdbcMySqlUtil.getConnection();
        try {

            connection.setAutoCommit(false);
            List<Request> requests = requestStore.getRequsts(INNER_JOIN_BOOK_ON_REQUEST_BOOK_ID_BOOK_ID);
            connection.commit();
            connection.setAutoCommit(true);
            return requests;

        } catch (SQLException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    public List<Request> getRequestSortedOfQuantity() {
        return requestStore.getRequsts(BY_QUANTITY_ASC);
    }
}
