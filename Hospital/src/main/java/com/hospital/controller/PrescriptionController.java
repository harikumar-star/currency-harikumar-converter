package com.hospital.controller;

import com.hospital.model.Prescription;
import com.hospital.model.PrescriptionRequest;
import com.hospital.service.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private  PrescriptionService prescriptionService;

    @PostMapping
    public Prescription createPrescription(@RequestBody PrescriptionRequest request) {
        return prescriptionService.createPrescription(request);
    }

    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionService.getAllPrescriptions();
    }
}