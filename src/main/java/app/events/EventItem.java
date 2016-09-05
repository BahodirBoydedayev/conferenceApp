package app.events;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventItem {
    private Long id;
    private String name;
    private String location;
    private Date date;
}
