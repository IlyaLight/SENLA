package com.senla.back.service;

import com.senla.api.service.IOrderService;
import com.senla.back.dao.api.IOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    IOrderDao orderDao;
}
