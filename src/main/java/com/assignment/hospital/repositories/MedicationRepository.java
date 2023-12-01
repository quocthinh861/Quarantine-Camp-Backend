package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.MedicationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends org.springframework.data.jpa.repository.JpaRepository<com.assignment.hospital.entites.MedicationEntity, Long>{


    // get list of all medications by list of ids
    List<MedicationEntity> findAllByUniqueCodeIn(List<Long> ids);
}
