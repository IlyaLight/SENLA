package com.senla.web.servlets;

import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetIncome")
public class GetIncome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order = (String) req.getParameter("order");
        String pattern = (String) req.getParameter("pattern");
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date dateFrom = new Date();
        Date dateto = new Date();
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.println(WebController.getInstance().getIncome(dateFrom, dateto));
    }
}
