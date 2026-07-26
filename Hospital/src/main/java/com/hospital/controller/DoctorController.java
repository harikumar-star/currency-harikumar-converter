package com.hospital.controller;


import com.hospital.model.Doctor;
import com.hospital.service.DoctoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("doctor")
public class DoctorController {

    @Autowired
    private DoctoService doctoService;

    @PostMapping
    public ResponseEntity<Doctor> dcotor(@RequestBody Doctor doctor) {
        Doctor d = doctoService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(d);
    }

}
