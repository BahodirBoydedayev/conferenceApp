package app.organization;


import app.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "app_organization")
public class Organization extends BaseEntity {

    @Column(name = "name")
    private String name;
}
