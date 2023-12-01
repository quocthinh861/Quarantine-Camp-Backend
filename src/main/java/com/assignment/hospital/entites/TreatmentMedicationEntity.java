package com.assignment.hospital.entites;

import com.assignment.hospital.models.PatientComorbidityId;
import com.assignment.hospital.models.TreatmentId;
import com.assignment.hospital.models.TreatmentMedicationKey;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@Table(name = "treatmentmedication")
@IdClass(TreatmentMedicationKey.class)
public class TreatmentMedicationEntity {
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

    @Id
    @Column(name = "medication_code")
    private Long medicationCode;
}
