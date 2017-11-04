package com.evedev.identityprovider.models.group_scheme;

import com.evedev.identityprovider.models.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 12.10.17
 */
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 2021445153578635758L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Post> posts;

    @ManyToMany(mappedBy="users")
    private Set<Group> groups;
}
