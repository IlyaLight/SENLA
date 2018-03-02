package com.senla.back.service;

import com.senla.api.service.IGoodsService;
import com.senla.back.dao.api.IGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsService implements IGoodsService {

    @Autowired
    IGoodsDao goodsDao;
}
