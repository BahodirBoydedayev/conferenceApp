package app.program;


import app.core.BaseEntity;
import app.location.Location;
import app.session.Session;
import app.track.Track;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "app_program")
public class Program extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;
    @OneToOne
    @JoinColumn(name = "track_id")
    private Track track;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;
}
