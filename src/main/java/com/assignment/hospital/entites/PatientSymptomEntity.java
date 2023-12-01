package com.assignment.hospital.entites;

import com.assignment.hospital.models.PatientComorbidityId;
import com.assignment.hospital.models.PatientSymptomId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "patientsymptom")
@IdClass(PatientSymptomId.class)
public class PatientSymptomEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private PatientEntity patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "symptom_name", referencedColumnName = "symptom_name")
    private SymptomEntity symptom;

    @Column(name = "record_time", nullable = false)
    private Timestamp recordTime;
}
