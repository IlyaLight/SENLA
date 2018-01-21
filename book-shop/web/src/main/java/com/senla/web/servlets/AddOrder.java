package com.senla.web.servlets;

import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddOrder")
public class AddOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String book = (String) req.getParameter("book");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        Integer id = Integer.valueOf(req.getParameter("id"));
        PrintWriter writer = resp.getWriter();
        writer.println(WebController.addOrder(book));
        writer.close();
    }
}
