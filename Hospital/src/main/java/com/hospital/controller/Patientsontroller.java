package com.hospital.controller;

import com.hospital.model.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Patientsontroller {

    @Autowired
    PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> patient(@RequestBody Patient patient) {
        Patient patient1 = patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(patient);
    }
}
