package com.assignment.hospital.entites;

import com.assignment.hospital.models.TreatmentId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "treatment")
@IdClass(TreatmentId.class)
public class TreatmentEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @Id
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private EmployeeEntity doctor;

    @Id
    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "result")
    private String result;
}
