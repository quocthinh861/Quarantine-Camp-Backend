package com.assignment.hospital.services;

import com.assignment.hospital.models.TestResult;
import com.assignment.hospital.repositories.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;
import java.util.UUID;

@Service
public class TestResultService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TestResultRepository testResultRepository;

    public List<TestResult> getTestResults(UUID patientId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("calculate_testing", TestResult.class);
        query.registerStoredProcedureParameter("pid", UUID.class, ParameterMode.IN);
        query.setParameter("pid", patientId);
        List<TestResult> results = query.getResultList();
        return results;
    }
}
