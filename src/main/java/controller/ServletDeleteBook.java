package controller;

import DAO.BookDAO;
import DAO.Imp.BookDAOImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by draqo on 29.06.2017.
 */
public class ServletDeleteBook  extends HttpServlet{

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
     * Deleting Book Entity from DB by ID*/
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        bookDAO.deleteBook(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/selectServlet.do");
        dispatcher.forward(req, resp);
    }
}
