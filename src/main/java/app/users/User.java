package app.users;

import app.core.BaseEntity;
import app.core.ROLE;
import app.events.Event;
import app.organization.Organization;
import app.subEvent.SubEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_users")
public class User extends BaseEntity {

    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "reg_date")
    private Date regDate;
    @Column(name = "status")
    private Boolean status = Boolean.TRUE;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToMany(mappedBy = "users")
    private List<SubEvent> subEventses;

    @ManyToMany(mappedBy = "users")
    private List<Event> events;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "app_user_roles", joinColumns = {
            @JoinColumn(name = "user_id")
    })

    @Column(name = "role", length = 32)
    @Enumerated(EnumType.STRING)
    private Set<ROLE> roles;
}
