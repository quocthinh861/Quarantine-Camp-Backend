package com.assignment.hospital.models;

import com.assignment.hospital.entites.EmployeeEntity;
import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.entites.TreatmentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentId implements Serializable {

    private PatientEntity patient;
    private EmployeeEntity doctor;
    private Timestamp startTime;

    // Constructors, getters, setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreatmentId)) return false;
        TreatmentId that = (TreatmentId) o;
        return patient.equals(that.patient) &&
                doctor.equals(that.doctor) &&
                startTime.equals(that.startTime);
    }

    @Override
    public int hashCode() {
        return patient.hashCode() + doctor.hashCode() + startTime.hashCode();
    }
}
