package app.events;


import app.core.BaseJpaDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoImpl extends BaseJpaDaoImpl<Event, Long> implements EventDao {

    public EventDaoImpl() {
        super(Event.class);
    }

    @Override
    public Iterable<Event> findAll(Long size, Long page, String text) {
        return entityManager.createQuery("select e from Event as e where e.name like :text order by e.date desc ", Event.class).setParameter("text", "%" + text + "%")
                .setFirstResult((page.intValue() - 1) * size.intValue()).setMaxResults(size.intValue()).getResultList();

    }

    @Override
    public Long count(String text) {
        return entityManager.createQuery("select count (e.id) from Event as e where e.name like :text", Long.class)
                .setParameter("text", "%" + text + "%").getSingleResult();
    }

    @Override
    public Iterable<Event> findByOwnerId(Long size, Long page, String text, Long id) {
        return entityManager.createQuery("select e from Event as e where e.owner.id = :id and e.name like :text order by e.date desc ", Event.class)
                .setParameter("id", id)
                .setParameter("text", "%" + text + "%")
                .setFirstResult((page.intValue() - 1) * size.intValue()).setMaxResults(size.intValue()).getResultList();

    }

    @Override
    public Long count(String text, Long id) {
        return entityManager.createQuery("select count (e.id) from Event as e where e.owner.id = :id and e.name like :text", Long.class)
                .setParameter("id", id).setParameter("text", "%" + text + "%").getSingleResult();
    }
}
