package app.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    private EventDao eventDao;

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Object findAll(Long size, Long page, String text) {
        Long count = eventDao.count(text);
        Iterable<Event> events = eventDao.findAll(size, page, text);
        Map<String, Object> map = new HashMap<>();
        map.put("events", events);
        map.put("count", count);
        return map;
    }

    @Transactional
    @Override
    public Event save(Event entity) {
        return eventDao.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Event findOne(Long id) {
        return eventDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<Event> findAll() {
        return eventDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        eventDao.delete(id);
    }
}
