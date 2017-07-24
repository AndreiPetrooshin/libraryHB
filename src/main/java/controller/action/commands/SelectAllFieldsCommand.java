package controller.action.commands;

import DAO.Imp.BookDAOImpl;
import models.Books;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by draqo on 24.07.2017.
 */
public class SelectAllFieldsCommand implements ActionCommand {



    public void execute(HttpServletRequest req) {
        List<Books> books;
        books  =  BookDAOImpl.getInstance().getAllElements();
        req.setAttribute("books", books);

    }
}
