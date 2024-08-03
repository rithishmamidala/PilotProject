package com.ust.Assessment.controller;

import com.ust.Assessment.model.SetInfo;
import com.ust.Assessment.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment/")
public class AssessmentController {


    @Autowired
    private AssessmentService assessmentService;

    @GetMapping("getAllSets")
    public List<SetInfo> getAllSets() {
        return assessmentService.getSetInfo();
    }
    @PostMapping("/create")
    public SetInfo createSet(@RequestBody SetInfo setInfo) {
        return assessmentService.createSetInfo(setInfo);
    }

}
