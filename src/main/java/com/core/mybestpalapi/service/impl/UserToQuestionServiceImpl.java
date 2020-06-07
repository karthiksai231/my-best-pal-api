package com.core.mybestpalapi.service.impl;

import com.core.mybestpalapi.common.Util;
import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IUserToQuestionRepository;
import com.core.mybestpalapi.persistence.model.UserToQuestion;
import com.core.mybestpalapi.service.IUserToQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserToQuestionServiceImpl extends AbstractService<UserToQuestion> implements IUserToQuestionService {
  IUserToQuestionRepository userToQuestionRepository;

  @Override
  public List<UserToQuestion> getAll() {
    return null;
  }

  @Override
  public UserToQuestion create(UserToQuestion entity) {
    entity.setId(UUID.randomUUID().toString());
    entity.setUserToQuestionId(Util.getRandomString(10));
    entity.setCreatedDate(new Date());
    entity.setUpdatedDate(new Date());

    return getRepoExecutor().save(entity);
  }

  @Override
  protected IUserToQuestionRepository getRepoExecutor() {
    return userToQuestionRepository;
  }
}
