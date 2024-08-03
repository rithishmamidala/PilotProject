package com.ust.Surveys.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Survey {
    @Id
    private String domain;
    private String status;
    private String email;
    private String companyName;
    private String setName;
}
