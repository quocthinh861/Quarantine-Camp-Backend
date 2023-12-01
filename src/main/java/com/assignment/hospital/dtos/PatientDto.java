package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.PatientEntity;
import com.assignment.hospital.models.TreatmentDto;

import java.util.List;
import java.util.UUID;

public class PatientDto {

    private UUID patientId;
    private Long uniqueNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;
    private String phoneNumber;
    private String previousLocation;
    private String condition;
    private List<PatientComorbidityDto> comorbidities;
    private List<SymptomDto> symptoms;
    private List<TreatmentDto> treatments;

    // Constructors, getters, and setters

    public PatientDto() {
    }

    // Getters and setters for each field

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public Long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPreviousLocation() {
        return previousLocation;
    }

    public void setPreviousLocation(String previousLocation) {
        this.previousLocation = previousLocation;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<PatientComorbidityDto> getComorbidities() {
        return comorbidities;
    }

    public void setComorbidities(List<PatientComorbidityDto> comorbidities) {
        this.comorbidities = comorbidities;
    }

    public List<SymptomDto> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<SymptomDto> symptoms) {
        this.symptoms = symptoms;
    }

    public List<TreatmentDto> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<TreatmentDto> treatmentDtos) {
        this.treatments = treatmentDtos;
    }

    public void loadFromEntity(PatientEntity entity) {
        this.patientId = entity.getPatientId();
        this.address = entity.getAddress();
        this.condition = entity.getCondition();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.middleName = entity.getMiddleName();
        this.phoneNumber = entity.getPhoneNumber();
        this.previousLocation = entity.getPreviousLocation();
        this.gender = entity.getGender();
        this.comorbidities = PatientComorbidityDto.fromEntities(entity.getComorbidities());
        this.symptoms = SymptomDto.fromEntities(entity.getSymptoms());
    }

    public static PatientDto fromEntity(PatientEntity entity) {
        var result = new PatientDto();
        result.loadFromEntity(entity);
        return result;
    }

    public static List<PatientDto> fromEntities(List<PatientEntity> entities) {
        return entities.stream().map(PatientDto::fromEntity).toList();
    }

    // You may also override toString() for debugging purposes

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientId=" + patientId +
                ", uniqueNumber=" + uniqueNumber +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", previousLocation='" + previousLocation + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
