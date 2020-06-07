package com.core.mybestpalapi.controller;

import com.core.mybestpalapi.common.controller.AbstractController;
import com.core.mybestpalapi.common.service.IService;
import com.core.mybestpalapi.dto.OptionDto;
import com.core.mybestpalapi.dto.QuestionDto;
import com.core.mybestpalapi.persistence.model.Option;
import com.core.mybestpalapi.persistence.model.Question;
import com.core.mybestpalapi.service.IOptionService;
import com.core.mybestpalapi.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("questions")
@AllArgsConstructor
public class QuestionsController extends AbstractController<Question> {
  IQuestionService questionService;
  IOptionService optionsService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity create(@RequestBody @Valid final QuestionDto questionDto) {
    String createdId = questionService.createQuestionWithOptions(getQuestionToCreate(questionDto),
        questionDto.getOptionDtos());

    return ResponseEntity.ok(createdId);
  }

  private Question getQuestionToCreate(QuestionDto questionDto) {
    return Question.builder()
        .question(questionDto.getQuestion())
        .userId("mockUserId")
        .build();
  }

  @Override
  protected IService<Question> getService() {
    return questionService;
  }
}
