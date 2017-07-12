package DAO;


import java.util.List;

/**
 * Created by draqo on 26.06.2017.
 */
public interface EntityDAO<T> {

    void addEntity(T t);

    void deleteEntity(int id);

    List<T> getAllElements();

    T getById(int id);

}
