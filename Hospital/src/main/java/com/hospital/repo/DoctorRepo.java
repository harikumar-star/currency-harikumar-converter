package com.hospital.repo;

import com.hospital.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo  extends JpaRepository<Doctor,Long> {
}
