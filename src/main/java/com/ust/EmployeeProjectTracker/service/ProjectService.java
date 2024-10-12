package com.ust.EmployeeProjectTracker.service;

import com.ust.EmployeeProjectTracker.dto.ProjectRequest;
import com.ust.EmployeeProjectTracker.model.Employee;
import com.ust.EmployeeProjectTracker.model.Project;
import com.ust.EmployeeProjectTracker.repo.EmployeeRepo;
import com.ust.EmployeeProjectTracker.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Project addProject(ProjectRequest projectRequest){
        List<Employee> employees = employeeRepo.findAllById(projectRequest.getEmployeeIds());

        Project project = new Project();
        project.setProjectId(projectRequest.getProject().getProjectId());
        project.setProjectName(projectRequest.getProject().getProjectName());
        project.setStartDate(projectRequest.getProject().getStartDate());
        project.setEndDate(projectRequest.getProject().getEndDate());
        project.setStatus(projectRequest.getProject().getStatus());
        project.setDescription(projectRequest.getProject().getDescription());
        project.setEmployees(employees);

        return projectRepo.save(project);
    }
}
