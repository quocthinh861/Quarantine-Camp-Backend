package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.entites.TreatmentEntity;
import com.assignment.hospital.models.TreatmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TreatmentRepository extends JpaRepository<TreatmentEntity, TreatmentId>{

    List<TreatmentEntity> findAllByPatient(PatientEntity patientEntity);


}
