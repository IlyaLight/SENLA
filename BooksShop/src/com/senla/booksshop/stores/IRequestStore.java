package com.senla.booksshop.stores;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.PersistException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IRequestStore extends Serializable {
    List<Request> getRequestList();

    void setRequestArrayList(ArrayList<Request> requestArrayList);

    void create(Request request);

    void read(Integer id);

    void update(Request request);

    void delete(Request request);

    List<Request> getRequsts(String options);
}
