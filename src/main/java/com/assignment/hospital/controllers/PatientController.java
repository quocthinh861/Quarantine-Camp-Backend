package com.assignment.hospital.controllers;

import com.assignment.hospital.dtos.ErrorResponseDto;
import com.assignment.hospital.dtos.PatientDto;
import com.assignment.hospital.dtos.SuccessResponseDto;
import com.assignment.hospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/getAllPatients")
    public ResponseEntity<Object> getAllPatients() {
        var status = HttpStatus.OK;
        try {
            var response = new SuccessResponseDto();
            response.result = patientService.getAllPatients();
            return new ResponseEntity<>(response, status);
        } catch (Exception err) {
            status = HttpStatus.BAD_REQUEST;
            var response = new ErrorResponseDto();
            response.errors = err;
            return new ResponseEntity<>(response, status);
        }
    }

    @GetMapping("/getPatientById/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable UUID id) {
        var status = HttpStatus.OK;
        try {
            var response = new SuccessResponseDto();
            response.result = patientService.getPatientById(id);
            return new ResponseEntity<>(response, status);
        } catch (Exception err) {
            status = HttpStatus.BAD_REQUEST;
            var response = new ErrorResponseDto();
            response.errors = err;
            return new ResponseEntity<>(response, status);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody PatientDto patientDto) {
        var status = HttpStatus.OK;
        try {
            var response = new SuccessResponseDto();
            response.result = patientService.createPatient(patientDto);
            return new ResponseEntity<>(response, status);
        } catch (Exception err) {
            status = HttpStatus.BAD_REQUEST;
            var response = new ErrorResponseDto();
            response.errors = err;
            return new ResponseEntity<>(response, status);
        }
    }
}
