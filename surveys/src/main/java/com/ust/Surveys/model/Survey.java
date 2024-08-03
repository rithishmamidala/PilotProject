package com.ust.Surveys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="survey")
public class Survey {
    @Id
    private String surveyId;
    private String domain;
    private String status;
    private String email;
    private String companyName;
    private String setName;
}
