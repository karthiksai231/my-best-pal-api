package com.core.mybestpalapi.service.impl;


import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.model.IUserRepository;
import com.core.mybestpalapi.persistence.model.User;
import com.core.mybestpalapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractService<User> implements IUserService {
    @Autowired
    IUserRepository userRepository;

    @Override
    protected final IUserRepository getRepoExecutor() {
        return userRepository;
    }
}
