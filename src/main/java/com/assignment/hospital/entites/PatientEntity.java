package com.assignment.hospital.entites;

import com.assignment.hospital.dtos.PatientDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Getter
@Setter
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id", columnDefinition = "uuid", updatable = false)
    private UUID patientId;

    @Column(name = "first_name", nullable = false, length = 10)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 30)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 10)
    private String lastName;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "phone_number", unique = true, nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "previous_location", nullable = true, length = 150)
    private String previousLocation;

    @Column(name = "condition", nullable = false, length = 10)
    private String condition;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PatientComorbidityEntity> comorbidities;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patientsymptom",
            joinColumns = {@JoinColumn(name = "patient_id", referencedColumnName = "patient_id")},
            inverseJoinColumns = {@JoinColumn(name = "symptom_name", referencedColumnName = "symptom_name")})
    private List<SymptomEntity> symptoms;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TreatmentEntity> treatments;


    // You may also override toString() for debugging purposes

    @Override
    public String toString() {
        return "PatientEntity{" +
                "patientId=" + patientId +
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

    public void loadFromDto(PatientDto patientDto) {
        this.setFirstName(patientDto.getFirstName());
        this.setMiddleName(patientDto.getMiddleName());
        this.setLastName(patientDto.getLastName());
        this.setGender(patientDto.getGender());
        this.setAddress(patientDto.getAddress());
        this.setPhoneNumber(patientDto.getPhoneNumber());
        this.setPreviousLocation(patientDto.getPreviousLocation());
        this.setCondition(patientDto.getCondition());

        if(patientDto.getComorbidities() != null) {
            List<PatientComorbidityEntity> comorbidityEntities = PatientComorbidityEntity.fromDtos(this, patientDto.getComorbidities());
            this.setComorbidities(comorbidityEntities);
        }

    }
}
