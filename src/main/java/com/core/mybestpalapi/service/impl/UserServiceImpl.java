package com.core.mybestpalapi.service.impl;


import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IUserRepository;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User entity) {
        return getRepoExecutor().save(entity);
    }

    @Override
    protected final IUserRepository getRepoExecutor() {
        return userRepository;
    }
}
