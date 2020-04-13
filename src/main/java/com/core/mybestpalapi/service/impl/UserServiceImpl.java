package com.core.mybestpalapi.service.impl;


import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.dto.Option;
import com.core.mybestpalapi.persistence.IUserRepository;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public User getById(String id) {
        Optional<User> user = getRepoExecutor().findById(id);

        return user.isPresent() ? user.get() : null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User create(User entity) {
        entity.setId(UUID.randomUUID().toString());
        entity.setCreated_Date(new Date());
        entity.setUpdated_Date(new Date());

        return getRepoExecutor().save(entity);
    }

    @Override
    protected final IUserRepository getRepoExecutor() {
        return userRepository;
    }
}
