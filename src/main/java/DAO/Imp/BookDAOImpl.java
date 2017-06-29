package DAO.Imp;

import DAO.BookDAO;
import models.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by draqo on 27.06.2017.
 */
public class BookDAOImpl implements BookDAO {
    @PersistenceUnit
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("CRM");


    public  void addBook(Books book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(book);
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }
    }


    public void deleteBook(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete from Books where idbooks=" + id).executeUpdate();
            entityManager.getTransaction().commit();
        }
        finally {
            entityManager.close();
        }

    }


    public List<Books> getAllBooks() {
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            List<Books> list = entityManager.createQuery("FROM Books").getResultList();
            entityManager.getTransaction().commit();
            return list;
        }
        finally {
            entityManager.close();
        }

    }


    public Books getBookbyId(int id) {
            EntityManager entityManager  =entityManagerFactory.createEntityManager();
            try{
                entityManager.getTransaction().begin();
              Books book = (Books) entityManager.createQuery
                      ("FROM Books where idbooks=" + id).getSingleResult();
              entityManager.getTransaction().commit();
              return book;
            }
            finally {
                entityManager.close();
            }
    }
}
