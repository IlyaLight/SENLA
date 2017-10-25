package com.senla.booksshop.stores;

import com.senla.booksshop.model.Request;
import com.senla.booksshop.utility.IdUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class RequestStore implements Serializable {

    private List<Request> requestList = new ArrayList<Request>();

    public RequestStore() {
    }

    public RequestStore(List<Request> requests) {
        this.requestList = requests;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestList = requestArrayList;
    }

    public void create(Request request){
        request.setId(IdUtil.getId(requestList));
        requestList.add(request);
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
