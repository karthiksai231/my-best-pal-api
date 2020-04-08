package com.core.mybestpalapi.common.service;

import com.core.mybestpalapi.persistence.model.User;

import java.io.Serializable;

public interface IService<T extends Serializable> extends ICurdOperations<T> {
}
