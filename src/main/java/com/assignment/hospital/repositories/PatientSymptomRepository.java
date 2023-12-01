package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.entites.PatientSymptomEntity;
import com.assignment.hospital.models.PatientSymptomId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientSymptomRepository extends JpaRepository<PatientSymptomEntity, PatientSymptomId> {
    List<PatientSymptomEntity> findAllByPatient(PatientEntity patient);
}
