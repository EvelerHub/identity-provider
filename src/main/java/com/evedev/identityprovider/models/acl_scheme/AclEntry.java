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
@Table(name = "acl_entry", uniqueConstraints = {@UniqueConstraint(name = "unique_acl_entry",
        columnNames = {"acl_object_identity", "ace_order"}
)})
public class AclEntry implements Serializable {

    private static final long serialVersionUID = -4692051229068851135L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "acl_object_identity",
            nullable = false,
            columnDefinition = "BIGINT UNSIGNED",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acl_entry_object")
    )
    private AclObjectIdentity aclObjectIdentity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sid",
            nullable = false,
            columnDefinition = "BIGINT UNSIGNED",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acl_entry_acl")
    )
    private AclSID sid;

    @Column(name = "ace_order", nullable = false, columnDefinition = "INTEGER")
    private int aceOrder;

    @Column(name = "mask", nullable = false, columnDefinition = "INTEGER UNSIGNED")
    private long mask;

    @Column(name = "granting", nullable = false, columnDefinition = "BOOLEAN")
    private boolean granting;

    @Column(name = "audit_success", nullable = false, columnDefinition = "BOOLEAN")
    private boolean auditSuccess;

    @Column(name = "audit_failure", nullable = false, columnDefinition = "BOOLEAN")
    private boolean auditFailure;
}