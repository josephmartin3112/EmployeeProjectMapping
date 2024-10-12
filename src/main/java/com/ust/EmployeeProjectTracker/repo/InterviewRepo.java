package com.ust.EmployeeProjectTracker.repo;

import com.ust.EmployeeProjectTracker.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long> {
    List<Interview> findByProject_ProjectIdAndResult(Long projectId, String result);
}
