package app.location;


import app.core.BaseEntity;
import app.events.Event;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "app_location")
public class Location extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "locations")
    private List<Event> events;
}
