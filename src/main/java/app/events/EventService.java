package app.events;


import app.core.BaseService;

public interface EventService extends BaseService<Event, Long>{
    Object findAll(Long size, Long page, String text);
}
