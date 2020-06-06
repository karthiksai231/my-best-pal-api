package com.core.mybestpalapi.common.controller;

import com.core.mybestpalapi.common.service.IService;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractController<T extends Serializable> {

    protected final T createInternal(final T resource) {
        // Pre-conditions
        //service call
        return getService().create(resource);
    }

    protected final T getByIdInternal(final String id) {
        return getService().getById(id);
    }

    protected abstract IService<T> getService();
}
