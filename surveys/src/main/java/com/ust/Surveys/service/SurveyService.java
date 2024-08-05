package com.ust.Surveys.service;

import com.ust.Surveys.client.FullResponse;
import com.ust.Surveys.client.SetInfo;
import com.ust.Surveys.feign.AssessmentClient;
import com.ust.Surveys.model.Survey;
import com.ust.Surveys.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private AssessmentClient assessmentClient;

    public Survey addSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }


    public FullResponse getSurvey(String surveyId) {
        Optional<Survey> survey = surveyRepository.findById(surveyId);
        if(survey.isPresent()){
            Survey survey1=survey.get();
            SetInfo setInfos=assessmentClient.getAssessmentBySetName(survey1.getSetName()).getBody();
            FullResponse res= new FullResponse();
            res.setSetName(survey1.getSetName());
            res.setEmail(survey1.getEmail());
            res.setDomain(survey1.getDomain());
            res.setStatus(survey1.getStatus());
            res.setCompanyName(survey1.getCompanyName());
            res.setSetinfos(setInfos);
            return res;
        }
        return null;
    }

    public List<FullResponse> getAllSurveys() {
        List<FullResponse> fullResponses=new ArrayList<>();
        List<Survey> surveys = surveyRepository.findAll();
        for (Survey survey : surveys) {
                SetInfo setInfos=assessmentClient.getAssessmentBySetName(survey.getSetName()).getBody();
                FullResponse res= new FullResponse();
                res.setSetName(survey.getSetName());
                res.setEmail(survey.getEmail());
                res.setDomain(survey.getDomain());
                res.setStatus(survey.getStatus());
                res.setCompanyName(survey.getCompanyName());
                res.setSetinfos(setInfos);
                fullResponses.add(res);
            }
        return fullResponses;
    }
}
