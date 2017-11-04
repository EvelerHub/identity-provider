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
@Table(name = "acl_object_identity", uniqueConstraints = {@UniqueConstraint(name = "uk_acl_object_identity",
        columnNames = {"object_id_class", "object_id_identity"}
)})
public class AclObjectIdentity implements Serializable {

    private static final long serialVersionUID = -25308459989429921L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "object_id_class",
            nullable = false,
            columnDefinition = "BIGINT UNSIGNED",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acl_object_identity_class")
    )
    private AclClass aclClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_object",
            columnDefinition = "BIGINT UNSIGNED",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acl_object_identity_parent")
    )
    private AclObjectIdentity parentObject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_sid",
            columnDefinition = "BIGINT UNSIGNED",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_acl_object_identity_owner")
    )
    private AclSID owner;

    @Column(name = "object_id_identity", nullable = false, columnDefinition = "BIGINT")
    private long objectIdIdentity;

    @Column(name = "entries_inheriting", nullable = false, columnDefinition = "BOOLEAN")
    private boolean entriesInheriting;
}
