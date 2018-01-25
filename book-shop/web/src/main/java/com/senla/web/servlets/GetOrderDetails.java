package com.senla.web.servlets;

import com.senla.api.exception.ObjectAvailabilityException;
import com.senla.web.WebController;
import com.senla.web.util.ResponseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetOrderDetails")
public class GetOrderDetails extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer orderId = Integer.valueOf((String) req.getParameter("orderId"));
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        try {
            resp.getWriter().println(WebController.getInstance().getOrderDetails(orderId));
        } catch (ObjectAvailabilityException e) {
            ResponseUtil.error(resp, e.getMessage(), 404);
        }
    }
}
