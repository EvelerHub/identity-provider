package com.evedev.identityprovider.models.acl_scheme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 18.10.17
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "acl_sid", uniqueConstraints = {@UniqueConstraint(name = "unique_acl_sid", columnNames = {"sid", "principal"})})
public class AclSID implements Serializable {

    private static final long serialVersionUID = 6608475132243786305L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private BigInteger id;

    @Column(name = "principal", nullable = false, columnDefinition = "BOOLEAN")
    private boolean principal;

    @Column(name = "sid", nullable = false, length = 100)
    private String sid;
}
