package com.core.mybestpalapi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class QuestionDto {
    private String question;
    private List<Option> options;
}
