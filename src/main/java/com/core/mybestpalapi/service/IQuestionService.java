package com.core.mybestpalapi.service;

import com.core.mybestpalapi.common.service.IService;
import com.core.mybestpalapi.dto.OptionDto;
import com.core.mybestpalapi.persistence.model.Question;

import java.util.List;

public interface IQuestionService extends IService<Question> {
  String createQuestionWithOptions(Question question, List<OptionDto> options);
}
