package com.ust.EmployeeProjectTracker.dto;

import com.ust.EmployeeProjectTracker.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
    private Project project;
    private List<Long> employeeIds;
}
