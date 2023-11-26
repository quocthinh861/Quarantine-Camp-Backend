package com.assignment.hospital.models;

import com.assignment.hospital.entites.PatientEntity;

import java.io.Serializable;
import java.util.Objects;

public class PatientComorbidityId implements Serializable {

    private PatientEntity patient;
    private String comorbidityName;

    // Constructors, getters, setters

    // Implement equals and hashCode
    // Make sure to compare both fields in equals and use Objects.hash in hashCode
    // This is necessary for Hibernate to correctly handle the composite key

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientComorbidityId that = (PatientComorbidityId) o;
        return Objects.equals(patient, that.patient) &&
                Objects.equals(comorbidityName, that.comorbidityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, comorbidityName);
    }
}
