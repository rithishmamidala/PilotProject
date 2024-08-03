package com.ust.Assessment.controller;

import com.ust.Assessment.dto.SetDto;
import com.ust.Assessment.model.Question;
import com.ust.Assessment.model.SetInfo;
import com.ust.Assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment/")
public class AssessmentController {


    @Autowired
    private AssessmentService assessmentService;



    @GetMapping
    public ResponseEntity<List<SetInfo>> getAllAssessments() {
        List<SetInfo> assessments = assessmentService.getAllAssessments();
        return ResponseEntity.ok(assessments);
    }
    @PostMapping("/createset")
    public ResponseEntity<SetInfo> createAssessment(@RequestBody SetInfo fullResponse) {
        SetInfo createdResponse = assessmentService.createAssessment(fullResponse);
        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{setname}")
    public ResponseEntity<SetInfo> getAssessmentBySetName(@PathVariable String setname) {
        SetInfo assessment = assessmentService.getAssessmentBySetName(setname);
        return ResponseEntity.ok(assessment);
    }

    @PutMapping("/{setName}/{questionId}")
    public ResponseEntity<Question> updateQuestionInAssessment(@PathVariable String setName, @PathVariable String questionId) {
        Question question = assessmentService.updateQuestionInAssessment(setName, questionId);
        return ResponseEntity.ok(question);
    }
    @DeleteMapping("/{setName}/{questionId}")
    public ResponseEntity<Void> deleteQuestionFromAssessment(@PathVariable String setName, @PathVariable String questionId) {
        assessmentService.deleteQuestionFromAssessment(setName, questionId);
        return ResponseEntity.noContent().build();
    }

}
