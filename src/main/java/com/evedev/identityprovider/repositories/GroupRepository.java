package com.evedev.identityprovider.repositories;

import com.evedev.identityprovider.models.group_scheme.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 20.10.17
 */
@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends CrudRepository<Group, Integer>{
}
