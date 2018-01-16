package com.senla.booksshop.stores;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.api.IRequestDao;
import dependencyinjection.annotation.Injection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Light on 27.09.2017.
 */
public class RequestStore implements IRequestStore {

    private static final String ERROR = "Error:";

    private static final long serialVersionUID = -6608314536820676274L;
    private List<Request> requestList = new ArrayList<Request>();
    @Injection
    private IRequestDao requestDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestStore.class);

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
        requestDao.create(request);
    }

    @Override
    public void read(Integer id){
            requestDao.getByPK(id);
    }

    @Override
    public void update(Request request){
            requestDao.update(request);
    }

    @Override
    public void delete(Request request){
            requestDao.delete(request);
    }

}
