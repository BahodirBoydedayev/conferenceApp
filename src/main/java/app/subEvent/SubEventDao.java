package app.subEvent;


import app.core.BaseDao;

public interface SubEventDao extends BaseDao<SubEvent, Long>{
    Iterable<SubEvent> findAll(Long size, Long page, String text, Long eventId);
    Long count(String text, Long eventId);
}
