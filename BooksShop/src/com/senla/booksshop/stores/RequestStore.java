package com.senla.booksshop.stores;

import com.senla.api.model.Request;
import com.senla.booksshop.utility.IdUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class RequestStore implements IRequestStore {

    private static final long serialVersionUID = -6608314536820676274L;
    private List<Request> requestList = new ArrayList<Request>();

    public RequestStore() {
    }

    public RequestStore(List<Request> requests) {
        this.requestList = requests;
    }

    @Override
    public List<Request> getRequestList() {
        return requestList;
    }

    @Override
    public void setRequestArrayList(ArrayList<Request> requestArrayList) {
        this.requestList = requestArrayList;
    }

    @Override
    public void create(Request request){
        request.setId(IdUtil.getId(requestList));
        requestList.add(request);
    }

    @Override
    public void read(){
        System.out.println("Will be later");
    }

    @Override
    public void update(){
        System.out.println("Will be later");
    }

    @Override
    public void delete(){
        System.out.println("Will be later");
    }
}
