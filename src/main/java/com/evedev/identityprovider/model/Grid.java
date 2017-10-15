package com.evedev.identityprovider.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 15.10.17
 */

@Getter
@Setter
@Entity
@Table(name = "grid")
public class Grid implements Serializable {

    private static final long serialVersionUID = -4773471009667199876L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grid")
    private List<User> users;
}
