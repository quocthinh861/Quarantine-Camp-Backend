package com.assignment.hospital.services;

import com.assignment.hospital.dtos.PatientDto;
import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<PatientDto> getAllPatients() {
        List<PatientEntity> patients = patientRepository.findAll();
        return PatientDto.fromEntities(patients);
    }

    @Transactional
    public PatientDto createPatient(PatientDto patientDto) {
        PatientEntity patient = new PatientEntity();
        patient.loadFromDto(patientDto);
        patient = patientRepository.save(patient);
        return PatientDto.fromEntity(patient);
    }
}
