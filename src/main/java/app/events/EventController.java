package app.events;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/events")
public class EventController {

    private EventService eventService;
    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@RequestParam("size") Long size, @RequestParam("page") Long page, @RequestParam("text") String text) {
        return eventService.findAll(size, page, text);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Event save(@RequestBody Event event) {
        return eventService.save(event);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Event findOne(@PathVariable Long id) {
        return eventService.findOne(id);
    }
}
