package com.ust.EmployeeProjectTracker.dto;

import com.ust.EmployeeProjectTracker.model.Interview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterviewRequest {
    private Interview interview;
    private Long employeeId;
    private Long projectId;
}
