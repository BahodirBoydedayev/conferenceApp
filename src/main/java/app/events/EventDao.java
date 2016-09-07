package app.events;


import app.core.BaseDao;

public interface EventDao extends BaseDao<Event, Long> {
    Iterable<Event> findAll(Long size, Long page, String text);

    Long count(String text);

    Long count(String text, Long id);

    Iterable<Event> findByOwnerId(Long size, Long page, String text, Long id);
}
