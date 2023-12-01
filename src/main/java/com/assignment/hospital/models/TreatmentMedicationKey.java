package com.assignment.hospital.models;

import com.assignment.hospital.entites.EmployeeEntity;
import com.assignment.hospital.entites.PatientEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentMedicationKey implements Serializable {
    private PatientEntity patient;
    private EmployeeEntity doctor;
    private Timestamp startTime;
    private Long medicationCode;
}
