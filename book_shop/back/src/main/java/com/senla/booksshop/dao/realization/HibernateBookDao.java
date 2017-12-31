package com.senla.booksshop.dao.realization;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class HibernateBookDao extends AbstractJpaHibernateDao<Book, Integer> implements IBookDao {

    private static final String ENTITY          = Book.class.getSimpleName();
    private static final String SELECT_QUERY    = "FROM " + ENTITY ;
    private static final String CREATE_QUERY    = "INSERT INTO " + ENTITY + " (name, date_publication, date_issue, price, inStock) VALUES (?,?,?,?,?);";
    private static final String UPDATE_QUERY    = "UPDATE " + ENTITY + " SET name = ?, date_publication = ?, date_issue = ?, price = ?, inStock = ? WHERE id = ?;";
    private static final String DELETE_QUERY    = "DELETE " + ENTITY + " WHERE id = :paramId";

    private static final String STALE_BOOKS     = SELECT_QUERY + " WHERE date_issue > ? ORDER BY ?;";
    private static final String RECEIVED_LATER_THAN     = SELECT_QUERY + "WHERE date_publication > ? ORDER BY ?;";

    private static final String ERROR           = "SQL Error:";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MySqlBookDao.class);

    @Override
    public List<Book> getStaleBooks(Date data, String columnName) {
        return null;
    }

    @Override
    public List<Book> booksReceivedLaterThan(Date data, String columnName) {
        return null;
    }



    @Override
    public String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return null;
    }

    @Override
    public String getUpdateQuery() {
        return null;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }


}

