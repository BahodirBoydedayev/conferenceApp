package app.subEvent;


import app.core.BaseEntity;
import app.events.Event;
import app.location.Location;
import app.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "app_sub_events")
public class SubEvent extends BaseEntity {

    @Column(name = "day")
    private Date date;
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "app_sub_events_users")
    private List<User> users;

    @Column(name = "type")
    private Type type = Type.CONFERENCES;
}
