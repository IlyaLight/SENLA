package com.senla.web.controller;

import com.senla.api.model.Goods;
import com.senla.api.service.IGoodsService;
import com.senla.back.dao.api.IGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/security")
public class SecureGoodsController {

    @Autowired
    IGoodsService goodsService;

//    @PostMapping("/createGoods")
//    public void createGoods(@RequestBody Goods goods, HttpServletResponse res) {
//        try {
//            goodsService.addGoods(goods);
//        }  catch (IncompleteDataException e) {
//            res.setStatus(400);
//            res.addHeader(ERROR, e.getClass().getSimpleName());
//        }
//    }

}
