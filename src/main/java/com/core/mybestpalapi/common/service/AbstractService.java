package com.core.mybestpalapi.common.service;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public abstract class AbstractService<T> {

    protected abstract MongoRepository<T, String> getRepoExecutor();

    public T create(final T entity) {
        //Preconditions.checkNotNull(entity);

        final T persistedEntity = getRepoExecutor().save(entity);

        return persistedEntity;
    }

    public T getById(final String id) {
        return (T) getRepoExecutor().findById(id);
    }
}
