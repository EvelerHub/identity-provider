package com.evedev.identityprovider.models.acl_scheme;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 18.10.17
 */
@Data
@Entity
@Table(name = "acl_class", uniqueConstraints = {@UniqueConstraint(name = "uk_acl_class", columnNames = {"class"})})
public class AclClass implements Serializable {

    private static final long serialVersionUID = -9053047267943878720L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private BigInteger id;

    @Column(name = "class", nullable = false, length = 100)
    private String clazz;
}
