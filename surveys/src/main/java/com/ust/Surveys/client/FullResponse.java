package com.ust.Surveys.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullResponse {
    private String surveyId;
    private String domain;
    private String status;
    private String email;
    private String companyName;
    private String setName;
    public SetInfo setinfos;
}
