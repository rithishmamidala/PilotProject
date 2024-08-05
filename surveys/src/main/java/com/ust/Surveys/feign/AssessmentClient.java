package com.ust.Surveys.feign;

import com.ust.Surveys.client.SetInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Assessment", url = "http://localhost:8082/assessment")
public interface AssessmentClient {
    @GetMapping("/{setname}")
    ResponseEntity<SetInfo> getAssessmentBySetName(@PathVariable String setname);
}
