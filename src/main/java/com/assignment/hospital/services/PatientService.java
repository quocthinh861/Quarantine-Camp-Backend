package com.assignment.hospital.services;

import com.assignment.hospital.dtos.MedicationDto;
import com.assignment.hospital.dtos.PatientDto;
import com.assignment.hospital.dtos.SymptomDto;
import com.assignment.hospital.entites.*;
import com.assignment.hospital.models.PatientSymptomId;
import com.assignment.hospital.models.TreatmentDto;
import com.assignment.hospital.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientSymptomRepository patientSymptomRepository;

    @Autowired
    private TreatmentMedicationRepository treatmentMedicationRepository;

    @Autowired
    private MedicationRepository medicationRepository;

    public List<PatientDto> getAllPatients() {
        List<PatientEntity> patients = patientRepository.findAllByWithSize(10);
        return PatientDto.fromEntities(patients);
    }

    @Transactional
    public PatientDto createPatient(PatientDto patientDto) {
        PatientEntity patient = new PatientEntity();
        patient.loadFromDto(patientDto);
        patient = patientRepository.save(patient);
        return PatientDto.fromEntity(patient);
    }

    public PatientDto getPatientById(UUID id) {
        Optional<PatientEntity> optionalPatient = patientRepository.findById(id);

        if (optionalPatient.isEmpty()) {
            return null;
        }

        PatientEntity patient = optionalPatient.get();
        List<SymptomEntity> symptoms = patient.getSymptoms();

        List<SymptomDto> symptomDtos = SymptomDto.fromEntities(symptoms);

        symptoms.forEach(symptom -> {
            PatientSymptomId patientSymptomId = new PatientSymptomId(patient, symptom);
            Optional<PatientSymptomEntity> optionalPatientSymptom = patientSymptomRepository.findById(patientSymptomId);

            optionalPatientSymptom.ifPresent(patientSymptom -> {
                SymptomDto matchingSymptomDto = symptomDtos.stream()
                        .filter(symptomDto -> symptomDto.symptomName.equals(symptom.getSymptomName()))
                        .findFirst()
                        .orElse(null);

                if (matchingSymptomDto != null) {
                    matchingSymptomDto.recordTime = patientSymptom.getRecordTime();
                }
            });
        });

        List<TreatmentDto> treatmentList = new ArrayList<>();
        List<TreatmentEntity> treatments = patient.getTreatments();

        treatments.forEach(treatment -> {
            List<TreatmentMedicationEntity> treatmentMedications =
                    treatmentMedicationRepository.findAllByPatientAndDoctorAndAndStartTime(patient, treatment.getDoctor(), treatment.getStartTime());

            if (treatmentMedications != null && !treatmentMedications.isEmpty()) {
                List<Long> medicationCodes = treatmentMedications.stream()
                        .map(TreatmentMedicationEntity::getMedicationCode)
                        .toList();

                if (medicationCodes != null && !medicationCodes.isEmpty()) {
                    List<MedicationEntity> medications = medicationRepository.findAllByUniqueCodeIn(medicationCodes);

                    if (medications != null && !medications.isEmpty()) {
                        TreatmentDto treatmentDto = TreatmentDto.fromEntity(treatment);
                        List<MedicationDto> medicationDtos = MedicationDto.fromEntities(medications);
                        treatmentDto.setMedications(medicationDtos);
                        treatmentList.add(treatmentDto);
                    }
                }
            }
        });

        PatientDto patientDto = PatientDto.fromEntity(patient);

        if(symptomDtos != null && symptomDtos.size() > 0)
        {
            // Sort symptomDtos by recordTime
            symptomDtos.sort((symptomDto1, symptomDto2) -> symptomDto2.recordTime.compareTo(symptomDto1.recordTime));
            patientDto.setSymptoms(symptomDtos);
        }

        if(treatmentList.size() > 0)
        {
            // Sort treatmentDtos by startTime
            treatmentList.sort((treatmentDto1, treatmentDto2) -> treatmentDto2.getStartTime().compareTo(treatmentDto1.getStartTime()));
            patientDto.setTreatments(treatmentList);
        }

        return patientDto;
    }
}
