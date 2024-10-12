package com.ust.EmployeeProjectTracker.service;

import com.ust.EmployeeProjectTracker.dto.InterviewRequest;
import com.ust.EmployeeProjectTracker.exception.ResourceNotFoundException;
import com.ust.EmployeeProjectTracker.model.Employee;
import com.ust.EmployeeProjectTracker.model.Interview;
import com.ust.EmployeeProjectTracker.model.Project;
import com.ust.EmployeeProjectTracker.repo.EmployeeRepo;
import com.ust.EmployeeProjectTracker.repo.InterviewRepo;
import com.ust.EmployeeProjectTracker.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepo interviewRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Interview addInterview(InterviewRequest interviewRequest){
        Interview interview = new Interview();

        interview.setInterviewId(interviewRequest.getInterview().getInterviewId());
        interview.setInterviewerName(interviewRequest.getInterview().getInterviewerName());
        interview.setInterviewDate(interviewRequest.getInterview().getInterviewDate());
        interview.setNotes(interviewRequest.getInterview().getNotes());
        interview.setResult(interviewRequest.getInterview().getResult());

        Employee employee = employeeRepo.findById(interviewRequest.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Project project = projectRepo.findById(interviewRequest.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));

        interview.setEmployee(employee);
        interview.setProject(project);

        return interviewRepo.save(interview);
    }
}
