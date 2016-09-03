package app.events;

import app.core.BaseEntity;
import app.location.Location;
import app.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_events")
public class Event extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "days")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
