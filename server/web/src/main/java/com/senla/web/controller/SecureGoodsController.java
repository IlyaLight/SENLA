package com.senla.web.controller;

import com.senla.api.exception.NotEnoughPermitsException;
import com.senla.api.service.IGoodsService;
import com.senla.web.controller.util.CheckDataUtil;
import com.senla.web.dto.GoodsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import java.util.Set;

@Controller
@RequestMapping("/security")
public class SecureGoodsController {

    @Autowired
    IGoodsService goodsService;

    @PostMapping("/createGoods")
    public void createGoods(@RequestBody GoodsDto goodsDto, HttpServletResponse res)  throws NotEnoughPermitsException {
        Set<ConstraintViolation<GoodsDto>> violations = CheckDataUtil.getValidator().validate(goodsDto);

    }

}
