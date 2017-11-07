package com.evedev.identityprovider.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 04.11.17
 */
@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2587894691879060960L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
}
