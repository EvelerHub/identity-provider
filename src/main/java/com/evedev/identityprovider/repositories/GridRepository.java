package com.evedev.identityprovider.repositories;

import com.evedev.identityprovider.models.Grid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * @author Alexander Eveler, alexander.eveler@gmail.com
 * @since 15.10.17
 */
@RepositoryRestResource(collectionResourceRel = "grids", path = "grids")
public interface GridRepository extends CrudRepository<Grid, Integer> {

    @Override
    @RestResource(exported = false)
    void delete(Grid grid);

    @Override
    @RestResource(exported = false)
    void delete(Integer integer);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Grid> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
