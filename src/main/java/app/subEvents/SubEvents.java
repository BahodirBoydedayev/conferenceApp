package app.subEvents;


import app.core.BaseEntity;
import app.events.Event;
import app.program.Program;
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
public class SubEvents extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "day")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Event event;

    @ManyToMany
    @JoinTable(name = "app_sub_events_users")
    private List<User> users;

    @OneToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @Column(name = "type")
    private Type type = Type.CONFERENCES;
}
