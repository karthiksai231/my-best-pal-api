package com.core.mybestpalapi.service.impl;

import com.core.mybestpalapi.common.service.AbstractService;
import com.core.mybestpalapi.dto.OptionDto;
import com.core.mybestpalapi.persistence.IQuestionRepository;
import com.core.mybestpalapi.persistence.model.Option;
import com.core.mybestpalapi.persistence.model.Question;
import com.core.mybestpalapi.persistence.model.UserToQuestion;
import com.core.mybestpalapi.service.IOptionService;
import com.core.mybestpalapi.service.IQuestionService;
import com.core.mybestpalapi.service.IUserToQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.core.mybestpalapi.common.Util.getRandomString;

@Service
@Transactional
@AllArgsConstructor
public class QuestionServiceImpl extends AbstractService<Question> implements IQuestionService {
  IQuestionRepository questionsRepository;
  IOptionService optionService;
  IUserToQuestionService userToQuestionService;

  @Override
  public final IQuestionRepository getRepoExecutor() {
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

  public String createQuestionWithOptions(Question question, List<OptionDto> options) {
    Question createdQuestion = create(question);

    options.stream()
        .forEach(op -> optionService
            .create(Option
                .builder()
                .questionId(createdQuestion.getId())
                .isAnswer(op.getIsAnswer())
                .answer(op.getOption())
                .build()
            )
        );

    String returnId = getRandomString(8);
    userToQuestionService.create(UserToQuestion.builder()
    .id(UUID.randomUUID().toString())
    .questionId(createdQuestion.getId())
    .userToQuestionId(returnId)
    .createdDate(new Date())
    .updatedDate(new Date())
    .build());

    return returnId;
  }
}
