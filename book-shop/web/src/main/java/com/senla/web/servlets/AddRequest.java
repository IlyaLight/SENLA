package com.senla.web.servlets;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.web.WebController;
import com.senla.web.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddRequest  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer idBook = Integer.valueOf(req.getParameter("idBook"));
        try {
            WebController.getInstance().addRequest(idBook);
        } catch (ObjectAvailabilityException e) {
            ResponseUtil.error(resp, e.getMessage(), 404);
        }
    }
}