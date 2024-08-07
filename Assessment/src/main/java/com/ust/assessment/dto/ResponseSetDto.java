package com.ust.assessment.dto;

import com.ust.assessment.model.SetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseSetDto {
    private Integer setId;
    private String setName;

    private String createdBy;
    private Date createdAt;
    private Date modifiedAt;

    private String domain;

    private SetStatus status;

    private List<ResponseQuestionDto> questions;
}
