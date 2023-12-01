package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.*;
import com.assignment.hospital.models.TreatmentMedicationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface TreatmentMedicationRepository extends JpaRepository<TreatmentMedicationEntity, TreatmentMedicationKey> {

    List<TreatmentMedicationEntity> findAllByPatientAndDoctorAndAndStartTime(PatientEntity patient, EmployeeEntity doctor, Timestamp startTime);
}
