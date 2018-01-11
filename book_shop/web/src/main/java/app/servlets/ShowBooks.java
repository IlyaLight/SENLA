package app.servlets;


import com.senla.client.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class ShowBooks extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        Controller controller = Controller.getInstance();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/ShowBooks.jsp");
        requestDispatcher.forward(req, resp);
    }
}
