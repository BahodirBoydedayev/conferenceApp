package app.core;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Component
public abstract class BaseJpaDaoImpl<T, E> implements BaseDao<T, E> {

    @PersistenceContext
    public EntityManager entityManager;

    private Class<T> clazz;

    public BaseJpaDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Transactional
    @Override
    public T save(T entity) {
        if (entity != null) {
            if (((BaseEntity) entity).getId() != null) {
                return entityManager.merge(entity);
            } else {
                entityManager.persist(entity);
                return entity;
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    public T findOne(E id) {
        Query query = entityManager.createQuery("select e from " + clazz.getName() + " as e where e.id = :id");
        query.setParameter("id", id);
        query.setMaxResults(1);
        if (!query.getResultList().isEmpty()) {
            try {
                return (T) query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<T> findAll() {
        Query query = entityManager.createQuery("select e from " + clazz.getName() + " as e "
                + "order by e.id asc ");
        return query.getResultList();
    }

    @Transactional
    @Override
    public void delete(E id) {
        T entity = findOne(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

}
