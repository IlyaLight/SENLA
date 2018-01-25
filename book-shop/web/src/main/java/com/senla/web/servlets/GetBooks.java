package com.senla.web.servlets;

import com.senla.booksshop.dao.api.IBookDao;
import com.senla.web.WebController;
import com.senla.web.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetBooks")
public class GetBooks extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order = (String) req.getParameter("order");
        switch(order){
            case IBookDao.NAME:
                ResponseUtil.allGoot(resp, WebController.getInstance().getBooksSortedByName());
                break;
            case IBookDao.PRICE:
                ResponseUtil.allGoot(resp, WebController.getInstance().getBooksSortedByPrice());
                break;
            case IBookDao.DATE_ISSUE:
                ResponseUtil.allGoot(resp, WebController.getInstance().getBooksSortedByDateIssue());
                break;
            case IBookDao.IN_STOCK:
                ResponseUtil.allGoot(resp, WebController.getInstance().getBooksSortedByStockAvailability());
                break;
            default:
                ResponseUtil.error(resp, "order = " + order + ": неверный параметр", 400);
        }
    }
}
