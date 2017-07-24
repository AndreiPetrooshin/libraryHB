package controller.action.commands;


import DAO.Imp.BookDAOImpl;
import models.Books;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by draqo on 24.07.2017.
 */
public class AddBookCommand implements ActionCommand  {



    public void execute(HttpServletRequest req) {
        List<Books> books;
        Books book = new Books();
        book.setBookName(req.getParameter("bookName"));
        book.setAuthorName(req.getParameter("authorName"));
        book.setDescription(req.getParameter("description"));
        book.setYear(Integer.valueOf(req.getParameter("year")));
        BookDAOImpl.getInstance().addEntity(book);
        books = BookDAOImpl.getInstance().getAllElements();
        req.setAttribute("books", books);
    }
}
