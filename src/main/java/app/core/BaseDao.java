package app.core;

public interface BaseDao<T, E> {
    T save(T entity);

    T findOne(E id);

    Iterable<T> findAll();

    void delete(E id);
}
