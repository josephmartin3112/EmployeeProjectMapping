package com.ust.EmployeeProjectTracker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {

    @Id
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;
    private String jobTitle;
    private String status;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Interview> interviews;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnore
    private List<Project> projects;
}
