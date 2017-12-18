package com.senla.booksshop.stores;

import com.senla.api.model.Request;
import com.senla.booksshop.dao.DaoFactory;
import com.senla.booksshop.dao.GenericDao;
import com.senla.booksshop.dao.PersistException;
import com.senla.booksshop.utility.IdUtil;
import com.senla.dependencyinjection.annotation.Injection;
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
    private DaoFactory daoFactory;
    private GenericDao genericDao = daoFactory.getDao(this.getClass());

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
        try {
            genericDao.persist(request);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void read(Integer id){
        try {
            genericDao.getByPK(id);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Request request){
        try {
            genericDao.update(request);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Request request){
        try {
            genericDao.delete(request);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Request> getRequsts(String options){
        try {
            return genericDao.get(options);
        } catch (PersistException e) {
            LOGGER.error(ERROR, e);
            throw new RuntimeException(e);
        }
    }
}
