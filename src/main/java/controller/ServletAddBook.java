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

/**
 * Created by draqo on 29.06.2017.
 */
public class ServletAddBook extends HttpServlet {

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
     * Create book entity
     * Adding to the DB
     * forwarding to the /addedPage.do servlet*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        Books books = new Books();
        books.setBookName(req.getParameter("bookName"));
        books.setAuthorName(req.getParameter("authorName"));
        books.setDescription(req.getParameter("description"));
        books.setYear(Integer.valueOf(req.getParameter("year")));


        bookDAO.addBook(books);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/selectServlet.do");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
