package com.evedev.identityprovider.models.group_scheme;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 19.10.17
 */
@Data
@Entity
@Table(name = "groups")
public class Group implements Serializable {

    private static final long serialVersionUID = 2994041127549278786L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(cascade = ALL)
    @JoinTable(name="user_group",
            joinColumns= @JoinColumn(name="group_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="user_id", referencedColumnName="id")
    )
    private Set<User> users;

    @OneToMany(mappedBy = "group")
    private Set<Authority> authorities;
}
