package app.track;


import app.core.BaseEntity;
import app.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "app_track")
public class Track extends BaseEntity {

    @ManyToMany
    @JoinTable(name = "app_users_events_track")
    private List<User> users;
}
