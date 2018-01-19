package com.senla.web.servlets;

import com.senla.booksshop.dao.api.IBookDao;
import com.senla.web.WebController;

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
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        switch(order){
            case IBookDao.NAME:
                writer.println(WebController.getInstance().getBooksSortedByName());
                break;
            case IBookDao.PRICE:
                writer.println(WebController.getInstance().getBooksSortedByPrice());
                break;
            case IBookDao.DATE_ISSUE:
                writer.println(WebController.getInstance().getBooksSortedByDateIssue());
                break;
            case IBookDao.IN_STOCK:
                writer.println(WebController.getInstance().getBooksSortedByStockAvailability());
                break;
        }
        writer.close();
    }
}
