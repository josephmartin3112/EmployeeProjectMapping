package com.ust.EmployeeProjectTracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="project")
public class Project {

    @Id
    private Long projectId;

    private String projectName;
    private String startDate;
    private String endDate;
    private String status;
    private String description;

    @ManyToMany
    @JoinTable(
            name = "employee_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;
}
