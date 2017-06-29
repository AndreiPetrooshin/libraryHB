package DAO;


import models.Books;

import java.util.List;

/**
 * Created by draqo on 26.06.2017.
 */
public interface BookDAO {

    void addBook(Books book);

    void deleteBook(int id);

    List getAllBooks();

    Books getBookbyId(int id);

}
