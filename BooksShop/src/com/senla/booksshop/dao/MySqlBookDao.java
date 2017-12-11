package com.senla.booksshop.dao;

import com.senla.api.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MySqlBookDao extends AbstractJDBCDao<Book, Integer> {

    public static final String SELECT_QUERY = "SELECT id, name, datePublication, dateIssue, price, inStock FROM books";
    public static final String CREATE_QUERY = "INSERT INTO books (name, datePublication, dateIssue, price, inStock) VALUES (?,?,?,?,?);";
    public static final String UPDATE_QUERY = "UPDATE books SET name = ?, datePublication = ?, dateIssue = ?, price = ?, inStock = ?;";
    public static final String DELETE_QUERY = "DELETE FROM books WHERE id= ?;";

    public MySqlBookDao(Connection connection) {
        super(connection);
    }

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
        LinkedList<Book> result = new LinkedList<Book>();
        try {
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setDateIssue(rs.getDate("datePublication"));
                book.setDateIssue(rs.getDate("dateIssue"));
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
    protected void prepareStatementForInsert(PreparedStatement statement, Book object) throws PersistException {

    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, Book object) throws PersistException {

    }

    @Override
    public Book create() throws PersistException {
        return null;
    }
}
