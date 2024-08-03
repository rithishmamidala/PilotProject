package com.ust.Surveys.service;

import com.ust.Surveys.model.Survey;
import com.ust.Surveys.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {
    @Autowired
    private SurveyRepository surveyRepository;

    public Survey addSurvey(Survey survey) {
        return surveyRepository.save(survey);
    }

    public Survey getSurvey(String surveyId) {
        return surveyRepository.findById(surveyId).orElse(null);
    }

    public List<Survey> getAllSurveys() {
        return surveyRepository.findAll();
    }
}
