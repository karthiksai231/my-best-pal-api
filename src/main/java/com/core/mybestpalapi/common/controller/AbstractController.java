package com.core.mybestpalapi.common.controller;

import com.core.mybestpalapi.common.service.IService;

import java.io.Serializable;

public abstract class AbstractController<T extends Serializable> {

    protected final void createInternal(final T resource) {
        // Pre-conditions
        //service call
        getService().create(resource);
    }

    protected abstract IService<T> getService();
}
