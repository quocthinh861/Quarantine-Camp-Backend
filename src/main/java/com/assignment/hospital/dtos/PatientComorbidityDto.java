package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.PatientComorbidityEntity;
import com.assignment.hospital.entites.PatientEntity;

import java.util.List;

public class PatientComorbidityDto {
    public String comorbidity;

    public void loadFromEntity(PatientComorbidityEntity entity) {
        this.comorbidity = entity.getComorbidityName();
    }

    public static PatientComorbidityDto fromEntity(PatientComorbidityEntity entity) {
        if(entity == null) {
            return null;
        }
        PatientComorbidityDto dto = new PatientComorbidityDto();
        dto.loadFromEntity(entity);
        return dto;
    }

    public static List<PatientComorbidityDto> fromEntities(List<PatientComorbidityEntity> entities) {
        if(entities == null
                || entities.isEmpty()) {
            return null;
        }
        return entities.stream().map(PatientComorbidityDto::fromEntity).collect(java.util.stream.Collectors.toList());
    }
}
