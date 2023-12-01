package com.assignment.hospital.dtos;

import com.assignment.hospital.entites.EmployeeEntity;

import java.util.UUID;

public class EmployeeDto {
    public UUID id;
    public String name;

    void loadFromEntity(EmployeeEntity employee) {
        this.id = employee.getId();
        this.name = employee.getFirstName() + " " + employee.getLastName();
    }

    public static EmployeeDto fromEntity(EmployeeEntity employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.loadFromEntity(employee);
        return dto;
    }
    // Other fields, getters, and setters
}