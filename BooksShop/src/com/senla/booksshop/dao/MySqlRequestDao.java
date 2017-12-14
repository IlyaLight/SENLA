package com.senla.booksshop.dao;

import com.senla.api.model.Request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlRequestDao extends AbstractJDBCDao<Request,Integer> {

    private static final String TABLE        = "request";
    private static final String SELECT_QUERY = "SELECT id, book_id, quantity FROM " + TABLE + " ";
    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (book_id, quantity) VALUES (?,?);";
    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET book_id = ?, quantity = ?;";
    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id= ?;";


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
    protected List<Request> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Request> result = new LinkedList<Request>();
        try {
            while (rs.next()) {
                Request request = new Request();
                request.setId(rs.getInt("id"));
                request.setBookId(rs.getInt("book_id"));
                request.setQuantity(rs.getInt("quantity"));
                result.add(request);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Request request) throws PersistException {
        try {
            statement.setInt(1, request.getBookId());
            statement.setInt(2, request.getQuantity());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Request request) throws PersistException {
        prepareStatementForInsert(statement, request);
        try {
            statement.setInt(3, request.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Request create() throws PersistException {
        return null;
    }
}
