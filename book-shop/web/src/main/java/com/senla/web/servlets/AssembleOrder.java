package com.senla.web.servlets;

import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AssembleOrder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer orderId = Integer.valueOf(req.getParameter("orderId"));
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        WebController.getInstance().assembleOrder(orderId, bookId);
    }
}
