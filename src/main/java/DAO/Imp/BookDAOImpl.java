package DAO.Imp;

import DAO.EntityDAO;
import DAO.EntityUtil;
import models.Books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import java.util.List;

/**
 * Created by draqo on 27.06.2017.
 */
public class BookDAOImpl implements EntityDAO<Books> {

    private static EntityManagerFactory entityManagerFactory = EntityUtil.getInstance();

    private static EntityDAO<Books> instance;

    private BookDAOImpl(){

    }

    public static EntityDAO<Books> getInstance(){
        if (instance == null){
            instance = new BookDAOImpl();
        }

        return instance;

    }




    public  void addEntity(Books book) {
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


    public void deleteEntity(int id) {
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


    public List<Books> getAllElements() {
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


    public Books getById(int id) {
            EntityManager entityManager  =entityManagerFactory.createEntityManager();
            try{
                entityManager.getTransaction().begin();
              Books book = (Books) entityManager.createQuery
                      ("FROM Books where idbooks=" + id).getSingleResult();
              entityManager.getTransaction().commit();
              return book;
            }
            catch (Exception e){
                return null;
            }
            finally {
                entityManager.close();
            }
    }
}
