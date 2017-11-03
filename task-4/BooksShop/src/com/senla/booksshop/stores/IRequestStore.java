package com.senla.booksshop.stores;

import com.senla.booksshop.model.Request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface IRequestStore extends Serializable {
    List<Request> getRequestList();

    void setRequestArrayList(ArrayList<Request> requestArrayList);

    void create(Request request);

    void read();

    void update();

    void delete();
}
