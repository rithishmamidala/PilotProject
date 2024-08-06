package com.ust.Assessment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAnswerDto {
    private Integer questionId;
    private Integer answerId;
    private String answer;
    private String suggestion;
}
