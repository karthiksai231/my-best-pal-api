package com.core.mybestpalapi.common.service;

import java.io.Serializable;
import java.util.List;

public interface ICurdOperations <T extends Serializable> {
    T getById(final long id);

    List<T> getAll();

    T create(final T resource);
}
