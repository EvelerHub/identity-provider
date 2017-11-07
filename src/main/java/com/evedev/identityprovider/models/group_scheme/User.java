package com.evedev.identityprovider.models.group_scheme;

import com.evedev.identityprovider.models.BaseEntity;
import com.evedev.identityprovider.models.Post;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.PERSIST;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 12.10.17
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true, exclude = {"groups", "posts"})
@ToString(callSuper = true, exclude = {"groups", "posts"})
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2021445153578635758L;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Post> posts;

    @ManyToMany
    @JoinTable(name = "user_group",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id")
    )
    private Set<Group> groups;

    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    public User(String email, String password, boolean enabled, String name, String surname, Set<Post> posts, Set<Group> groups) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.name = name;
        this.surname = surname;
        this.posts = posts;
        this.groups = groups;
    }
}
