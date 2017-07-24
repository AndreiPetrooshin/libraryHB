package controller.action.commands;

import DAO.EntityDAO;
import DAO.Imp.BookDAOImpl;
import models.Books;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by draqo on 24.07.2017.
 */
public class DeleteByIdCommand implements ActionCommand {


    public void execute(HttpServletRequest req) {
        List<Books> books;
        BookDAOImpl.getInstance().deleteEntity(Integer.parseInt(req.getParameter("id")));
        books = BookDAOImpl.getInstance().getAllElements();
        req.setAttribute("books", books);

    }
}
