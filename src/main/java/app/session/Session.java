package app.session;

import app.core.BaseEntity;
import app.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "app_sessions")
public class Session extends BaseEntity {

    @Column(name = "paper")
    private String paper;
    @OneToOne
    @JoinColumn(name = "app_speaker_id")
    private User speaker;
}
