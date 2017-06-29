package controller;

import DAO.BookDAO;
import DAO.Imp.BookDAOImpl;
import models.Books;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by draqo on 29.06.2017.
 */
public class ServletGetById extends HttpServlet {

    private static BookDAO bookDAO;
    /**
     * Initialize bookDAO when
     * servlet is init
     */
    @Override
    public void init() throws ServletException {
        super.init();
        bookDAO =  new BookDAOImpl();
    }

    /**
     * Getting book by id
     * forwarding to index.jsp*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Books book  = bookDAO.getBookbyId(id);
        List<Books> books = new ArrayList<Books>();
        books.add(book);
        req.setAttribute("books", books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }
}
