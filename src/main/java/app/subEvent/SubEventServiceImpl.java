package app.subEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class SubEventServiceImpl implements SubEventService {

    private SubEventDao subEventDao;

    @Autowired
    public void setSubEventDao(SubEventDao subEventDao) {
        this.subEventDao = subEventDao;
    }

    @Transactional(readOnly = true)
    @Override
    public Object findAll(Long size, Long page, String text, Long eventId) {
        Long count = subEventDao.count(text, eventId);
        Iterable<SubEvent> subEvents = subEventDao.findAll(size, page, text, eventId);
        Map<String, Object> map = new HashMap<>();
        map.put("subEvents", subEvents);
        map.put("count", count);
        return map;
    }

    @Transactional
    @Override
    public SubEvent save(SubEvent entity) {
        return subEventDao.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public SubEvent findOne(Long id) {
        return subEventDao.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<SubEvent> findAll() {
        return subEventDao.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        subEventDao.delete(id);
    }
}
