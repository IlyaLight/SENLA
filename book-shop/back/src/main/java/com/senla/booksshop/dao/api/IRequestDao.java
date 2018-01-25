package com.senla.booksshop.dao.api;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Request;

import java.util.List;

public interface IRequestDao extends IGenericDao<Request, Integer>{

    public static final String ID           = "id";
    public static final String BOOK_ID      = "book_id";
    public static final String QUANTITY     = "quantity";
    public static final String TABLE        = "request";

    List<Request> getAll(String sortingColumn);

    Request getRequestByBookId(Integer bookId) throws ObjectAvailabilityException;
}
