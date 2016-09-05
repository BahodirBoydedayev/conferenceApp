package app.subEvent;


import app.core.BaseService;

public interface SubEventService extends BaseService<SubEvent, Long>{
    Object findAll(Long size, Long page, String text, Long eventId);
}
