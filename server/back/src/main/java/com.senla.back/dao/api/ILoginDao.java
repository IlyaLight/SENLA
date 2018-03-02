package com.senla.back.dao.api;

import com.senla.api.model.Login;

public interface ILoginDao extends IGenericDao<Login>{

    boolean checkLoginDuplicate(String login);
}
