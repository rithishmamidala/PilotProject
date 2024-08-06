package com.ust.Assessment.dto;

import com.ust.Assessment.model.Answer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
