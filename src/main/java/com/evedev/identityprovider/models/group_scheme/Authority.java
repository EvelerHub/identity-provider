package com.evedev.identityprovider.models.group_scheme;

import com.evedev.identityprovider.models.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 19.10.17
 */
@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authorities")
public class Authority extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4445127442447796852L;

    @NonNull
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
