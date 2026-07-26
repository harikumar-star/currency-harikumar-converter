package com.hospital.service;


import com.hospital.model.Doctor;
import com.hospital.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctoService {

    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

}
