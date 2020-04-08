package com.core.mybestpalapi.common.service;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public abstract class AbstractService<T> {

    protected abstract MongoRepository<T, UUID> getRepoExecutor();

    public T create(final T entity) {
        //Preconditions.checkNotNull(entity);

        final T persistedEntity = getRepoExecutor().save(entity);

        return persistedEntity;
    }
}
