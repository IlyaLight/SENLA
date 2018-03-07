package com.senla.back.service;

import com.senla.api.service.IAdderssService;
import com.senla.back.dao.api.IAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AddressService implements IAdderssService {

    @Autowired
    IAddressDao addressDao;

}
