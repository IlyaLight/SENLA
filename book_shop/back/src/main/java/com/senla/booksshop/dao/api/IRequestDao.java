package com.senla.booksshop.dao.api;

import com.senla.api.model.Request;

import java.util.List;

public interface IRequestDao {

    void create(Request t);

    Request getByPK(int key);

    void  update(Request t);

    void delete(Request t);

    List<Request> getAll(String... sortingColumn);
}
