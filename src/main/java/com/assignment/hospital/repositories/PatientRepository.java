package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, UUID> {

    @Query(value = "SELECT * FROM patient ORDER BY 1 DESC LIMIT ?1", nativeQuery = true)
    List<PatientEntity> findAllByWithSize(int size);
}
