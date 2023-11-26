package com.assignment.hospital.entites;

import com.assignment.hospital.models.PatientComorbidityId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "patientcomorbidity")
@IdClass(PatientComorbidityId.class)
public class PatientComorbidityEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private PatientEntity patient;

    @Id
    @Column(name = "comorbidity_name")
    private String comorbidityName;

    // You may also override toString() for debugging purposes

    @Override
    public String toString() {
        return "PatientComorbidityEntity{" +
                "patient=" + patient +
                ", comorbidityName='" + comorbidityName + '\'' +
                '}';
    }
}
