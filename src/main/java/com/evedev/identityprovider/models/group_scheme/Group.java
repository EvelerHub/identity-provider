package com.evedev.identityprovider.models.group_scheme;

import com.evedev.identityprovider.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 19.10.17
 */
@Data
@EqualsAndHashCode(callSuper = true, exclude={"users", "authorities"})
@ToString(callSuper = true, exclude={"users", "authorities"})
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
public class Group extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2994041127549278786L;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "groups")
    private Set<User> users;

    @OneToMany(mappedBy = "group")
    private Set<Authority> authorities;
}
