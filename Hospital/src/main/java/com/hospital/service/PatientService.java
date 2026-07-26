package com.hospital.service;

import com.hospital.model.Patient;
import com.hospital.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private  PatientRepo patientRepo;

    public Patient addPatient(Patient patient)
    {
        return patientRepo.save(patient);
    }


}
