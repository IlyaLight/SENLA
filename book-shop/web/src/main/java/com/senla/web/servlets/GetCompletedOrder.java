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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetCompletedOrder")
public class GetCompletedOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String order = (String) req.getParameter("order");
        String pattern = (String) req.getParameter("pattern");
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date dateFrom = new Date();
        Date dateto = new Date();
        try {
            dateFrom = formatter.parse((String) req.getParameter("dateFrom"));
            dateto = formatter.parse((String) req.getParameter("dateto"));
        } catch (ParseException e) {
            throw new Error(e);//?!
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        if (order == null) {
            writer.println(WebController.getInstance().getCompletedOrder(dateFrom, dateto));
            writer.close();
            return;
        }
        switch(order){
            case IOrderDao.DATA_COMPLETION:
                writer.println(WebController.getInstance().getCompletedOrderSortedByCompletedData(dateFrom, dateto));
                break;
            case IOrderDao.PRICE:
                writer.println(WebController.getInstance().getCompletedOrderSortedByPrice(dateFrom, dateto));
                break;
        }
        writer.close();
    }
}
