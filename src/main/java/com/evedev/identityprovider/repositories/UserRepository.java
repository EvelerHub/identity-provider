package com.evedev.identityprovider.repositories;

import com.evedev.identityprovider.models.group_scheme.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 13.10.17
 */
@Transactional
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    User findOne(Integer integer);

    User findByEmail(String email);
}
