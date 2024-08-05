package com.ust.Surveys.controller;

import com.ust.Surveys.client.FullResponse;
import com.ust.Surveys.client.SetInfo;
import com.ust.Surveys.feign.AssessmentClient;
import com.ust.Surveys.model.Survey;
import com.ust.Surveys.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")

public class SurveyController {
    @Autowired
    private SurveyService surveyService;

    @Autowired
    private AssessmentClient assessmentFeignClient;


    @PostMapping("/addSurvey")
    public Survey addSurvey(Survey survey) {
        return surveyService.addSurvey(survey);
    }

    @GetMapping("/Survey/{surveyId}")
    public FullResponse getSurvey(@PathVariable String surveyId) {
        return surveyService.getSurvey(surveyId);
    }

    @GetMapping("/surveys")
    public List<FullResponse> getAllSurveys() {
        return surveyService.getAllSurveys();
    }
}
