package com.senla.booksshop.dao;

import com.senla.api.model.Book;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlBookDao extends AbstractJDBCDao<Book, Integer> {

    private static final String TABLE        = "book";
    private static final String SELECT_QUERY = "SELECT id, name, date_publication, date_issue, price, inStock FROM " + TABLE + " ";
    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (name, date_publication, date_issue, price, inStock) VALUES (?,?,?,?,?);";
    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET name = ?, date_publication = ?, date_issue = ?, price = ?, inStock = ? WHERE id = ?;";
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
    protected List<Book> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<Book> result = new LinkedList<>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDatePublication(rs.getDate("date_publication"));
                book.setDateIssue(rs.getDate("date_issue"));
                book.setPrice(rs.getFloat("price"));
                book.setInStock(rs.getInt("inStock"));
                result.add(book);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, Book book) throws PersistException {
        try {
            statement.setString(1, book.getName());
            statement.setDate(2, new java.sql.Date(book.getDatePublication().getTime()));
            statement.setDate(3, new java.sql.Date(book.getDateIssue().getTime()));
            statement.setFloat(4, book.getPrice());
            statement.setInt(5, book.getInStock());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Book book) throws PersistException {
        prepareStatementForInsert(statement, book);
        try {
            statement.setInt(6, book.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public Book create() throws PersistException {
        return null;
    }
}
