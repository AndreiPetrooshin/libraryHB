package DAO;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by draqo on 08.07.2017.
 */
public class EntityUtil {


   private static final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("CRM");


    public static EntityManagerFactory getInstance() {
        synchronized (entityManagerFactory){
            return entityManagerFactory;
        }
    }

    private EntityUtil() {
    }
}
