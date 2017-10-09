package com.senla.booksshop.stores;

import com.senla.booksshop.model.Request;

import java.util.ArrayList;


/**
 * Created by Light on 27.09.2017.
 */
public class RequestStore {

    private ArrayList<Request> requestArrayList = new ArrayList<Request>();

    public ArrayList<Request> getRequestArrayList() {
        return requestArrayList;
    }

    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestArrayList = requestArrayList;
    }

    public void create(){
        System.out.println("Will be later");
    }

    public void read(){
        System.out.println("Will be later");
    }

    public void update(){
        System.out.println("Will be later");
    }

    public void delete(){
        System.out.println("Will be later");
    }
}
