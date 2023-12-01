package com.assignment.hospital.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "symptom")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SymptomEntity {
    @Id
    @Column(name = "symptom_name", nullable = false)
    private String symptomName;

    @Column(name = "is_serious", nullable = false)
    private boolean isSerious;
}
