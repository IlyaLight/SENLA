package app.servlets;


import com.google.gson.Gson;
import com.senla.api.Command;
import com.senla.api.Response;
import com.senla.api.model.Book;
import com.senla.client.Client;
import com.senla.client.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ShowBooks extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Controller controller = Controller.getInstance();
        //List<Book> books = controller.getBooksSortedByName();
        Gson GSON = new Gson();


        Client client = Client.getInstance();
        Response response = client.writeCommand(new Command("getBooksSortedByName"));
        List<Book> books = (List<Book>)response.getResult();
        Book book = GSON.fromJson(books.get(0), Book.class);;
        //System.out.println(books.get(0).getName());
        //req.setAttribute("books", controller.getBooksSortedByName());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/ShowBooks.jsp");
        requestDispatcher.forward(req, resp);
    }
}
