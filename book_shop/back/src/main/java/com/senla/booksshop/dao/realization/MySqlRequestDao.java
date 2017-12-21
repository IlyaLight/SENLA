package com.senla.booksshop.dao.realization;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.api.IRequestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlRequestDao extends AbstractJDBCDao<Request,Integer> implements IRequestDao {

    public static final String ID = "id";
    public static final String BOOK_ID = "book_id";
    public static final String QUANTITY = "quantity";
    public static final String TABLE        = "request";

    private static final String SELECT_QUERY = "SELECT tab.id, book_id, quantity FROM " + TABLE + " tab ";
    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (book_id, quantity) VALUES (?,?);";
    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id= ?;";

    private static final String ERROR           = "SQL Error:";
    private static final Logger LOGGER          = LoggerFactory.getLogger(MySqlRequestDao.class);

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
    protected List<Request> parseResultSet(ResultSet rs)  {
        LinkedList<Request> result = new LinkedList<Request>();
        try {
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt(ID));
                request.setBookId(rs.getInt(BOOK_ID));
                request.setQuantity(rs.getInt(QUANTITY));
                result.add(request);
            }
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Request request)  {
        try {
            statement.setInt(1, request.getBookId());
            statement.setInt(2, request.getQuantity());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Request request)  {
        prepareStatementForInsert(statement, request);
        try {
            statement.setInt(3, request.getId());
        } catch (Exception e) {
            LOGGER.error(ERROR, e);
        }
    }


}
