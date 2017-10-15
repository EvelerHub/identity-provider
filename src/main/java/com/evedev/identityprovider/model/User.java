package com.evedev.identityprovider.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 12.10.17
 */

@Entity
@Getter
@Setter
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 2021445153578635758L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grid_id")
    private Grid grid;
}
