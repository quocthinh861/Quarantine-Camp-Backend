package com.assignment.hospital.repositories;

import com.assignment.hospital.models.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    // Define any custom query methods if needed
}