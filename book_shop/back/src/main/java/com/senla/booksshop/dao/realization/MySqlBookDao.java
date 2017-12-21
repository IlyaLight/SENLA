package com.senla.booksshop.dao.realization;

import com.senla.api.model.Book;
import com.senla.booksshop.dao.api.IBookDao;
import com.senla.booksshop.utility.JdbcMySqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MySqlBookDao extends AbstractJDBCDao<Book, Integer> implements IBookDao{


    public static final String ID               = "id";
    public static final String NAME             = "name";
    public static final String DATE_PUBLICATION = "date_publication";
    public static final String DATE_ISSUE       = "date_issue";
    public static final String PRICE            = "price";
    public static final String IN_STOCK         = "in_stock";
    public static final String TABLE            = "book";

    private static final String SELECT_QUERY    = "SELECT id, name, date_publication, date_issue, price, inStock FROM " + TABLE + " ";
    private static final String CREATE_QUERY    = "INSERT INTO " + TABLE + " (name, date_publication, date_issue, price, inStock) VALUES (?,?,?,?,?);";
    private static final String UPDATE_QUERY    = "UPDATE " + TABLE + " SET name = ?, date_publication = ?, date_issue = ?, price = ?, inStock = ? WHERE id = ?;";
    private static final String DELETE_QUERY    = "DELETE FROM " + TABLE + " WHERE id= ?;";

    private static final String STALE_BOOKS     = SELECT_QUERY + " WHERE date_issue > ? ORDER BY ?;";
    private static final String RECEIVED_LATER_THAN     = SELECT_QUERY + "WHERE date_publication > ? ORDER BY ?;";

    private static final String ERROR           = "SQL Error:";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MySqlBookDao.class);

    private static final SimpleDateFormat DATE_FORMAT   = new  SimpleDateFormat("'yyyy-MM-dd'");


    @Override
    public String getSelectQuery() {
        return SELECT_QUERY;
    }

    @Override
    public String getCreateQuery() {
        return CREATE_QUERY;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_QUERY;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_QUERY;
    }

    @Override
    protected List<Book> parseResultSet(ResultSet rs)  {
        LinkedList<Book> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt(ID));
                book.setName(rs.getString(NAME));
                book.setDatePublication(rs.getDate(DATE_PUBLICATION));
                book.setDateIssue(rs.getDate(DATE_ISSUE));
                book.setPrice(rs.getFloat(PRICE));
                book.setInStock(rs.getInt(IN_STOCK));
                result.add(book);
            }
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Book book) {
        try {
            statement.setString(1, book.getName());
            statement.setDate(2, new java.sql.Date(book.getDatePublication().getTime()));
            statement.setDate(3, new java.sql.Date(book.getDateIssue().getTime()));
            statement.setFloat(4, book.getPrice());
            statement.setInt(5, book.getInStock());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Book book) {
        prepareStatementForInsert(statement, book);
        try {
            statement.setInt(6, book.getId());
        } catch (SQLException e) {
            LOGGER.error(ERROR, e);
        }
    }


    @Override
    public List<Book> getStaleBooks(Date data, String columnName) {
        return getBooksDC(STALE_BOOKS, data, columnName);
    }

    @Override
    public List<Book> booksReceivedLaterThan(Date data, String columnName) {
        return getBooksDC(RECEIVED_LATER_THAN, data, columnName);
    }

    private List<Book> getBooksDC(String sql , Date data, String columnName) {
        List<Book> list = new ArrayList<>();
        try (PreparedStatement statement = JdbcMySqlUtil.getConnection().prepareStatement(sql)){
            statement.setDate(1, new java.sql.Date(data.getTime()));
            statement.setString(2, columnName);
            ResultSet rs = statement.executeQuery();
            list =  parseResultSet(rs);
        } catch (SQLException e) {
            LOGGER.error(ERROR, e);
        }
        return list;
    }


}
