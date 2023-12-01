package com.assignment.hospital.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "medication")
public class MedicationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_code")
    private Long uniqueCode;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "effect", length = 150)
    private String effect;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicationEntity that = (MedicationEntity) o;

        return uniqueCode != null ? uniqueCode.equals(that.uniqueCode) : that.uniqueCode == null;
    }

    @Override
    public int hashCode() {
        return uniqueCode != null ? uniqueCode.hashCode() : 0;
    }

    // Override toString if needed

    @Override
    public String toString() {
        return "Medication{" +
                "uniqueCode=" + uniqueCode +
                ", name='" + name + '\'' +
                ", effect='" + effect + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                '}';
    }
}

