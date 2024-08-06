package com.ust.Assessment.controller;

import com.ust.Assessment.dto.ResponseSetDto;
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
    public ResponseEntity<List<SetDto>> getAllAssessments() {
        List<SetDto> assessments = assessmentService.getAllSet();
        return ResponseEntity.ok(assessments);
    }
    @PostMapping("/createset")
    public ResponseEntity<ResponseSetDto> createAssessment(@RequestBody SetInfo fullResponse) {
        ResponseSetDto createdResponse = assessmentService.saveSetInfo(fullResponse);
        return new ResponseEntity<>(createdResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{setname}")
    public ResponseEntity<ResponseSetDto> getAssessmentBySetName(@PathVariable String setname) {
        ResponseSetDto assessment = assessmentService.getSetBySetName(setname);
        return ResponseEntity.ok(assessment);
    }

    @PutMapping("/{setName}/{questionId}")
    public ResponseEntity<Question> updateQuestionInAssessment(@PathVariable String setName, @PathVariable Integer questionId,@RequestBody Question question) {
        Question rquestion = assessmentService.modifySetQuestionInfo(setName, questionId,question);
        return ResponseEntity.ok(rquestion);
    }
    @DeleteMapping("/{setName}/{questionId}")
    public ResponseEntity<Void> deleteQuestionFromAssessment(@PathVariable String setName, @PathVariable Integer questionId) {
        assessmentService.deleteQuestionFromAssessment(setName, questionId);
        return ResponseEntity.noContent().build();
    }

}
