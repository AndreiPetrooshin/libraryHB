package controller;

import DAO.EntityDAO;
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


public class ServletForBooks extends HttpServlet {

    private static EntityDAO<Books> bookDAO;

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
        resp.setCharacterEncoding("utf-8");

        String action = req.getParameter("action");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        List<Books> books;

        if( action!=null && action.equalsIgnoreCase("deleteById")){
            bookDAO.deleteEntity(Integer.parseInt(req.getParameter("id")));
            books = bookDAO.getAllElements();
            req.setAttribute("books", books);
        }
        else if(req.getParameter("bookName") != null){
            Books book = new Books();
            book.setBookName(req.getParameter("bookName"));
            book.setAuthorName(req.getParameter("authorName"));
            book.setDescription(req.getParameter("description"));
            book.setYear(Integer.valueOf(req.getParameter("year")));
            bookDAO.addEntity(book);
            books = bookDAO.getAllElements();
            req.setAttribute("books", books);
        }

        dispatcher.forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        String action = req.getParameter("action");
        List<Books> books = new ArrayList<Books>() ;


        if(action.equalsIgnoreCase("selectAllFields")){
            books  = bookDAO.getAllElements();
            req.setAttribute("books", books);
        }
        else if(action.equalsIgnoreCase("findById")){
            Books book  = bookDAO.getById(Integer.parseInt(req.getParameter("id")));
            books.add(book);
            req.setAttribute("books", books);
        }
        dispatcher.forward(req, resp);
    }

}
