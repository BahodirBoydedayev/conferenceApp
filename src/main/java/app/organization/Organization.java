package app.organization;


import app.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_organization")
public class Organization extends BaseEntity {

    @Column(name = "name")
    private String name;
}
