package com.evedev.identityprovider.repositories;

import com.evedev.identityprovider.models.Post;
import com.evedev.identityprovider.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 15.10.17
 */
@Transactional
@RepositoryRestResource(collectionResourceRel = "posts", path = "posts")
public interface PostRepository extends CrudRepository<Post, Long> {
}
