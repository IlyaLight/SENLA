package com.senla.booksshop.stores;

import com.senla.booksshop.model.Request;

import java.util.ArrayList;


/**
 * Created by Light on 27.09.2017.
 */
public class RequestCollection {

    private ArrayList<Request> requestArrayList = new ArrayList<Request>();

    public ArrayList<Request> getRequestArrayList() {
        return requestArrayList;
    }

    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestArrayList = requestArrayList;
    }

    public void create(){}

    public void read(){}

    public void update(){}

    public void delete(){}
}
