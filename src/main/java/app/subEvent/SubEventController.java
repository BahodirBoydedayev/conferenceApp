package app.subEvent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subEvents")
public class SubEventController {

    private SubEventService subEventService;

    @Autowired
    public void setSubEventService(SubEventService subEventService) {
        this.subEventService = subEventService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object findAll(@RequestParam Long size, @RequestParam Long page,
                          @RequestParam String text, @RequestParam Long eventId) {
        return subEventService.findAll(size, page, text, eventId);
    }
}
