package com.senla.back.service;

import com.senla.api.model.User;
import org.springframework.stereotype.Component;

@Component
//@Scope(scopeName = "request")
public class UserHandler implements IUsertHandler {

    private User user;

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Integer getId() {
        return user.getId();
    }

    @Override
    public User getUser() {
        return user;
    }
}
