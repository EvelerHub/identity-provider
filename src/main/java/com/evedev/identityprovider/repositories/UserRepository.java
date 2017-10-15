package com.evedev.identityprovider.repositories;

import com.evedev.identityprovider.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 13.10.17
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    User findOne(Integer integer);
}
