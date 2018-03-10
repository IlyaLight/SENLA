package com.senla.api.service;

import com.senla.api.model.Login;

public interface ILoginService {
    boolean checkLoginDuplicate(Login login);
}
