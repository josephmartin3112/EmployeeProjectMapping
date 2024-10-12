package com.ust.EmployeeProjectTracker.controller;

import com.ust.EmployeeProjectTracker.dto.EmployeeResponse;
import com.ust.EmployeeProjectTracker.dto.FailedInterviewResponse;
import com.ust.EmployeeProjectTracker.model.Employee;
import com.ust.EmployeeProjectTracker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("/{projectId}/employees")
    public List<EmployeeResponse> getEmployeesByProject(@PathVariable Long projectId) {
        return employeeService.getEmployeesByProject(projectId);
    }

    @GetMapping("/{projectId}/failed-interviews")
    public List<FailedInterviewResponse> getFailedInterviewsByProject(@PathVariable Long projectId) {
        return employeeService.getFailedInterviewsByProject(projectId);
    }
}
