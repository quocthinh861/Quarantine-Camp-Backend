package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.SymptomEntity;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class SymptomDto {
    public String symptomName;
    public Timestamp recordTime;
    public boolean isSerious;

    private void loadFromEntity(SymptomEntity symptom) {
        this.symptomName = symptom.getSymptomName();
        this.isSerious = symptom.isSerious();
    }

    public static SymptomDto fromEntity(SymptomEntity symptom) {
        SymptomDto symptomDto = new SymptomDto();
        symptomDto.loadFromEntity(symptom);
        return symptomDto;
    }

    public static List<SymptomDto> fromEntities(List<SymptomEntity> symptoms)
    {
        if(symptoms == null || symptoms.isEmpty())
        {
            return null;
        }
        return symptoms.stream().map(SymptomDto::fromEntity).collect(Collectors.toList());
    }
}
