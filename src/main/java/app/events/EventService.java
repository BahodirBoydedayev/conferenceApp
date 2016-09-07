package app.events;


import app.core.BaseService;

import java.security.Principal;

public interface EventService extends BaseService<Event, Long> {
    Object findAll(Long size, Long page, String text);

    Object findByOwnerId(Long size, Long page, String text, Long id);

    Event save(Event event, Principal principal);
}
