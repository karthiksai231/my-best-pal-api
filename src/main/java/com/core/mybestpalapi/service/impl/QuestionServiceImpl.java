package com.core.mybestpalapi.service.impl;

import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.persistence.IQuestionsRepository;
import com.core.mybestpalapi.persistence.model.Question;
import com.core.mybestpalapi.service.IQuestionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImpl extends AbstractService<Question> implements IQuestionService {
  IQuestionsRepository questionsRepository;

  @Override
  public final IQuestionsRepository getRepoExecutor() {
    return questionsRepository;
  }

  @Override
  public List<Question> getAll() {
    return null;
  }

  @Override
  public Question create(Question entity) {
    entity.setId(UUID.randomUUID().toString());
    entity.setCreatedDate(new Date());
    entity.setUpdatedDate(new Date());

    return getRepoExecutor().save(entity);
  }
}
