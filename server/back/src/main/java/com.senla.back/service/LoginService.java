package com.senla.back.service;

import com.senla.api.model.Login;
import com.senla.api.service.ILoginService;
import com.senla.back.dao.api.ILoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService implements ILoginService {

    @Autowired
    ILoginDao loginDao;

    @Transactional(readOnly=true)
    @Override
    public boolean checkLoginDuplicate(Login login){
        return loginDao.checkLoginDuplicate(login);
    }
}
