package com.core.mybestpalapi.service.impl;


import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IUserRepository;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl extends AbstractService<User> implements IUserService {

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
        entity.setCreatedDate(new Date());
        entity.setUpdatedDate(new Date());

        return getRepoExecutor().save(entity);
    }

    @Override
    protected final IUserRepository getRepoExecutor() {
        return userRepository;
    }
}
