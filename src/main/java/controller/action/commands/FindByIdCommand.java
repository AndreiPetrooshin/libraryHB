package controller.action.commands;


import DAO.Imp.BookDAOImpl;
import models.Books;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by draqo on 24.07.2017.
 */
public class FindByIdCommand implements ActionCommand {


    public void execute(HttpServletRequest req) {
        List<Books> books = new ArrayList<Books>();
        Books book;
        try {
            book = BookDAOImpl.getInstance().getById(Integer.parseInt(req.getParameter("id")));
        }
        catch (NumberFormatException e){
            req.setAttribute("exception", "Enter the number of Book");
            return;
        }
        if(book == null){
            req.setAttribute("exception", "This book is not exist");
        }
        else {
            books.add(book);
            req.setAttribute("books", books);

        }

    }
}
