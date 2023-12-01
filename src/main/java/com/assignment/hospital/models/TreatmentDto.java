package com.assignment.hospital.models;

import com.assignment.hospital.dtos.EmployeeDto;
import com.assignment.hospital.dtos.MedicationDto;
import com.assignment.hospital.dtos.PatientDto;
import com.assignment.hospital.entites.TreatmentEntity;
import lombok.Getter;
import lombok.Setter;


import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class TreatmentDto {

    private PatientDto patient;
    private EmployeeDto doctor;
    private Timestamp startTime;
    private Timestamp endTime;
    private String result;
    private List<MedicationDto> medications;

    // Constructors, getters, and setters

    public TreatmentDto() {
        // Default constructor
    }

    public TreatmentDto(PatientDto patient, EmployeeDto doctor, Timestamp startTime,
                        Timestamp endTime, String result, List<MedicationDto> medications) {
        this.patient = patient;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
        this.result = result;
        this.medications = medications;
    }

    void loadFromEntity(TreatmentEntity treatment) {
        this.doctor = EmployeeDto.fromEntity(treatment.getDoctor());
        this.startTime = treatment.getStartTime();
        this.endTime = treatment.getEndTime();
        this.result = treatment.getResult();
    }

    public static TreatmentDto fromEntity(TreatmentEntity treatment) {
        TreatmentDto dto = new TreatmentDto();
        dto.loadFromEntity(treatment);
        return dto;
    }

    public static List<TreatmentDto> fromEntities(List<TreatmentEntity> treatments) {
        return treatments.stream().map(treatment -> {
            TreatmentDto dto = new TreatmentDto();
            dto.loadFromEntity(treatment);
            return dto;
        }).collect(java.util.stream.Collectors.toList());
    }

    public void setMedications(List<MedicationDto> medicationDtos) {
        this.medications = medicationDtos;
    }

    // Other methods if needed
}
