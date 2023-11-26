package com.assignment.hospital.repositories;

import com.assignment.hospital.entites.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    List<RoleEntity> findAllByIdIn(List<Long> ids);
}
