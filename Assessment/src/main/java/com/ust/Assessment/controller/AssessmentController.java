package com.ust.Assessment.controller;

import com.ust.Assessment.dto.ResponseQuestionDto;
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
        return ResponseEntity.ok(assessmentService.getAllSet());
    }
    @PostMapping
    public ResponseEntity<ResponseSetDto> createAssessment(@RequestBody SetInfo fullResponse) {
        return new ResponseEntity<>(assessmentService.saveSetInfo(fullResponse), HttpStatus.CREATED);
    }
    @GetMapping("/set/{setname}")
    public ResponseEntity<ResponseSetDto> getAssessmentBySetName(@PathVariable String setname) {
        return ResponseEntity.ok(assessmentService.getSetBySetName(setname));
    }

    @PutMapping("/{setId}/{questionId}")
    public ResponseEntity<ResponseQuestionDto> updateQuestionInAssessment(@PathVariable Integer setId, @PathVariable Integer questionId, @RequestBody Question question) {

        return ResponseEntity.ok(assessmentService.modifySetQuestionInfo(setId, questionId,question));
    }
    @DeleteMapping("/{setId}/{questionId}")
    public ResponseEntity<Void> deleteQuestionFromAssessment(@PathVariable Integer setId, @PathVariable Integer questionId) {
        assessmentService.deleteQuestionFromAssessment(setId, questionId);
        return ResponseEntity.noContent().build();
    }

}