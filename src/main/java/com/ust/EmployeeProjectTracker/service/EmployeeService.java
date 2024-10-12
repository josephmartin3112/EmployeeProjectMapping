package com.ust.EmployeeProjectTracker.service;

import com.ust.EmployeeProjectTracker.dto.EmployeeResponse;
import com.ust.EmployeeProjectTracker.dto.FailedInterviewResponse;
import com.ust.EmployeeProjectTracker.model.Employee;
import com.ust.EmployeeProjectTracker.repo.EmployeeRepo;
import com.ust.EmployeeProjectTracker.repo.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private InterviewRepo interviewRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<EmployeeResponse> getEmployeesByProject(Long projectId) {
        return employeeRepo.findByProjects_ProjectId(projectId)
                .stream()
                .map(employee -> new EmployeeResponse(
                        employee.getEmployeeId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail()))
                .collect(Collectors.toList());
    }

    public List<FailedInterviewResponse> getFailedInterviewsByProject(Long projectId) {
        return interviewRepo.findByProject_ProjectIdAndResult(projectId, "fail")
                .stream()
                .map(interview -> new FailedInterviewResponse(
                        interview.getEmployee().getEmployeeId(),
                        interview.getEmployee().getFirstName(),
                        interview.getEmployee().getLastName(),
                        interview.getInterviewDate()))
                .collect(Collectors.toList());
    }
}
