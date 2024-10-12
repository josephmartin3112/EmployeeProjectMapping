package com.ust.EmployeeProjectTracker.controller;

import com.ust.EmployeeProjectTracker.dto.InterviewRequest;
import com.ust.EmployeeProjectTracker.model.Interview;
import com.ust.EmployeeProjectTracker.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping("/add")
    public ResponseEntity<Interview> createInterview(@RequestBody InterviewRequest interviewRequest){
        return ResponseEntity.ok(interviewService.addInterview(interviewRequest));
    }
}
