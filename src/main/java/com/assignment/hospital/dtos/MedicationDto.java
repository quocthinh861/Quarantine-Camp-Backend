package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.MedicationEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class MedicationDto {
    public Long uniqueCode;
    public String name;
    public String effect;
    public BigDecimal price;
    public Timestamp expirationDate;

    void loadFromEntity(MedicationEntity medication) {
        this.uniqueCode = medication.getUniqueCode();
        this.name = medication.getName();
        this.effect = medication.getEffect();
        this.price = medication.getPrice();
        this.expirationDate = medication.getExpirationDate();
    }

    public static MedicationDto fromEntity(MedicationEntity medication) {
        MedicationDto dto = new MedicationDto();
        dto.loadFromEntity(medication);
        return dto;
    }


    public static List<MedicationDto> fromEntities(List<MedicationEntity> medications) {
        return medications.stream().map(medication -> {
            MedicationDto dto = new MedicationDto();
            dto.loadFromEntity(medication);
            return dto;
        }).collect(java.util.stream.Collectors.toList());
    }
}
