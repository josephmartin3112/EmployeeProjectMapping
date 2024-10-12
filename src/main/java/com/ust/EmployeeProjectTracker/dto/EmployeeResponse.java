package com.ust.EmployeeProjectTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
}
