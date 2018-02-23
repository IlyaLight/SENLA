package com.senla.back.service;

import com.senla.api.model.User;

public interface IUsertHandler {

    void setUser(User user);

    Integer getId();

    User getUser();
}
