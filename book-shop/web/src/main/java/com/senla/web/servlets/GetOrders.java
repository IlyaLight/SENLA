package com.senla.web.servlets;

import com.senla.booksshop.dao.api.IOrderDao;
import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetOrders")
public class GetOrders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order = (String) req.getParameter("order");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        switch(order){
            case IOrderDao.ID:
                writer.println(WebController.getInstance().getOrderSortedById());
                break;
            case IOrderDao.DATA_COMPLETION:
                writer.println(WebController.getInstance().getOrderSortedByDataCompletion());
                break;
            case IOrderDao.PRICE:
                writer.println(WebController.getInstance().getOrderSortedByPrice());
                break;
            case IOrderDao.STATUS:
                writer.println(WebController.getInstance().getOrderSortedByStatus());
                break;
        }
        writer.close();
    }
}
