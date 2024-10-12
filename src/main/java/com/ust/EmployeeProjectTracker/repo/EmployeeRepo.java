package com.ust.EmployeeProjectTracker.repo;

import com.ust.EmployeeProjectTracker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByProjects_ProjectId(Long projectId);
}
