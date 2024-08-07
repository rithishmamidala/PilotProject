package com.ust.assessment.dto;

import com.ust.assessment.model.SetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetDto {

    private Integer setId;
    private String setName;

    private String createdBy;

    private String domain;

    private SetStatus status;
}
