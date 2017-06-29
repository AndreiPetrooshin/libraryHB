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
import java.util.List;


public class ServletSelectAll extends HttpServlet {

    private static BookDAO bookDAO;

    /**
     * Initialize bookDAO when
     * servlet is init
     */
    @Override
    public void init() throws ServletException {
        super.init();
        bookDAO = new BookDAOImpl();
    }

    /**
     * Getting all books from Data Base
     * and forward to Index.jsp page our request
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        List<Books> booksList = bookDAO.getAllBooks();
        req.setAttribute("books", booksList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
