package com.assignment.hospital.entites;

import com.assignment.hospital.dtos.PatientComorbidityDto;
import com.assignment.hospital.models.PatientComorbidityId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    void loadFromDto(PatientEntity patient, String comorbidityName) {
        this.patient = patient;
        this.comorbidityName = comorbidityName;
    }

    public PatientComorbidityEntity() {
    }

    @JsonIgnore
    public static PatientComorbidityEntity fromDto(PatientEntity patient, String comorbidityName) {
        PatientComorbidityEntity patientComorbidityEntity = new PatientComorbidityEntity();
        patientComorbidityEntity.loadFromDto(patient, comorbidityName);
        return patientComorbidityEntity;
    }

    @JsonIgnore
    public static List<PatientComorbidityEntity> fromDtos(PatientEntity patient, List<PatientComorbidityDto> comorbidities) {
        if(comorbidities == null
                || comorbidities.isEmpty()) {
            return null;
        }
        return comorbidities.stream().map(comorbidity -> PatientComorbidityEntity.fromDto(patient, comorbidity.comorbidity)).collect(java.util.stream.Collectors.toList());
    }
}
