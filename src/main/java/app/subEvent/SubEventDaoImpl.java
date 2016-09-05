package app.subEvent;


import app.core.BaseJpaDaoImpl;
import org.springframework.stereotype.Repository;

@Repository
public class SubEventDaoImpl extends BaseJpaDaoImpl<SubEvent, Long> implements SubEventDao {

    public SubEventDaoImpl() {
        super(SubEvent.class);
    }

    @Override
    public Iterable<SubEvent> findAll(Long size, Long page, String text, Long eventId) {
        return entityManager.createQuery("select e from SubEvent as e where e.event.id = :eventId and e.name like :text order by e.id desc ", SubEvent.class)
                .setParameter("eventId", eventId)
                .setParameter("text", "%" + text + "%")
                .setFirstResult((page.intValue() - 1) * size.intValue()).setMaxResults(size.intValue()).getResultList();

    }

    @Override
    public Long count(String text, Long eventId) {
        return entityManager.createQuery("select count (e.id) from SubEvent as e where e.event.id = :eventId and e.name like :text", Long.class)
                .setParameter("eventId", eventId)
                .setParameter("text", "%" + text + "%")
                .getSingleResult();
    }
}
