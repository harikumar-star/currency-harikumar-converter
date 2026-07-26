package com.hospital.repo;

import com.hospital.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository  extends JpaRepository<Prescription,Long> {
}
