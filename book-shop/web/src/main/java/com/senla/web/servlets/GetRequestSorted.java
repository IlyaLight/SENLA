package com.senla.web.servlets;

import com.senla.booksshop.dao.api.IOrderDao;
import com.senla.booksshop.dao.api.IRequestDao;
import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetRequestSorted")
public class GetRequestSorted extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order = (String) req.getParameter("order");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        switch(order){
            case "BookName":
                writer.println(WebController.getInstance().getRequestSortedByBookName());
                break;
            case IRequestDao.QUANTITY:
                writer.println(WebController.getInstance().getRequestSortedOfQuantity());
                break;
        }
        writer.close();
    }
}
