package com.senla.web.servlets;

import com.senla.web.WebController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/GetStaleBooksPrice")
public class GetStaleBooksPrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String pattern = (String) req.getParameter("pattern");
        String date = (String) req.getParameter("date");
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        try {
            writer.println(WebController.getInstance().getStaleBooksPrice(formatter.parse(date)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        writer.close();
    }
}
