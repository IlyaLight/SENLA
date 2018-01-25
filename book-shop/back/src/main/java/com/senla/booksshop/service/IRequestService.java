package com.senla.booksshop.service;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.api.model.Request;

import java.util.List;

public interface IRequestService {
    List<Request> getAll();

    List<Request> getRequestSortedOfQuantity();

    Request getRequestByBookId(Integer bookId) throws ObjectAvailabilityException;

    void create(Request request);
}
