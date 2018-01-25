package com.senla.web.servlets;

import com.senla.web.WebController;
import com.senla.web.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetRequestByBookName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String bookName = (String) req.getParameter("bookName");
    ResponseUtil.allGoot(resp, WebController.getInstance().findRequestByBookName(bookName));
    }
}
