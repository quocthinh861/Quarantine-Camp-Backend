package com.assignment.hospital.models;

import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.entites.SymptomEntity;

import java.io.Serializable;
import java.util.Objects;

public class PatientSymptomId implements Serializable {
    private PatientEntity patient;
    private SymptomEntity symptom;

    public PatientSymptomId(PatientEntity patient, SymptomEntity symptom) {
        this.patient = patient;
        this.symptom = symptom;
    }

    // Constructors, getters, setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientSymptomId)) return false;
        PatientSymptomId that = (PatientSymptomId) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(symptom, that.symptom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, symptom);
    }
}
