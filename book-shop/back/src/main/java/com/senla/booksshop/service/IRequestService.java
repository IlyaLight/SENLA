package com.senla.booksshop.service;

import com.senla.api.model.Request;

import java.util.List;

public interface IRequestService {
    List<Request> getAll();

    List<Request> getRequestSortedOfQuantity();
}
