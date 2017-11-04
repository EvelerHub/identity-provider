package com.evedev.identityprovider.models.group_scheme;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 19.10.17
 */
@Data
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    private static final long serialVersionUID = -4445127442447796852L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
