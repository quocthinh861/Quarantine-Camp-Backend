package com.assignment.hospital.controllers;

import com.assignment.hospital.models.TestResult;
import com.assignment.hospital.services.TestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/test-results")
public class TestController {
    @Autowired
    private TestResultService testResultService;

    @GetMapping("/{patientId}")
    public List<TestResult> getTestResults(@PathVariable UUID patientId) {
        return testResultService.getTestResults(patientId);
    }
}
