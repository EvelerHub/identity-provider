package com.evedev.identityprovider.models;

import com.evedev.identityprovider.models.group_scheme.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 15.10.17
 */
@Data
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    private static final long serialVersionUID = -4773471009667199876L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
}
