package com.ust.EmployeeProjectTracker.controller;

import com.ust.EmployeeProjectTracker.dto.ProjectRequest;
import com.ust.EmployeeProjectTracker.model.Project;
import com.ust.EmployeeProjectTracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequest projectRequest){
        return ResponseEntity.ok(projectService.addProject(projectRequest));
    }
}
