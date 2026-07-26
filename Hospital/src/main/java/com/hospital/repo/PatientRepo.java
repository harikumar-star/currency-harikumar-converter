package com.hospital.repo;

import com.hospital.model.Patient;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
