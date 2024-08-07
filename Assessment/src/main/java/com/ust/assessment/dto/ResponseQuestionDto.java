package com.ust.assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseQuestionDto {

    private Integer setId;
    private Integer questionId;
    private String questionText;
    private List<ResponseAnswerDto> answers;
}
