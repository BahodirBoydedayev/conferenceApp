package app.events;


import app.location.LocationService;
import app.users.User;
import app.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService {

    private EventDao eventDao;
    private UserRepository userRepository;
    private LocationService locationService;

    @Autowired
    public void setEventDao(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
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

    @Transactional(readOnly = true)
    @Override
    public Object findByOwnerId(Long size, Long page, String text, Long id) {
        Long count = eventDao.count(text, id);
        Iterable<Event> events = eventDao.findByOwnerId(size, page, text, id);
        Map<String, Object> map = new HashMap<>();
        map.put("events", events);
        map.put("count", count);
        return map;
    }

    @Transactional
    @Override
    public Event save(Event entity, Principal principal) {
        locationService.save(entity.getLocation());
        User user = userRepository.findByLogin(principal.getName());
        entity.setOwner(user);
        return eventDao.save(entity);
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
