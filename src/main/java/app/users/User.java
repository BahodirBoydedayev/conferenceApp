package app.users;

import app.core.BaseEntity;
import app.core.ROLE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_users")
public class User extends BaseEntity{

    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password")
    private String passcode;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "reg_date")
    private Date regDate;
    @Column(name = "status")
    private Integer status;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id")
    })
    @Column(name = "role", length = 32)
    @Enumerated(EnumType.STRING)
    private List<ROLE> roles;
}
