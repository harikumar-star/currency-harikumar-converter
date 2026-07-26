package com.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    Patient patientId;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    Doctor doctorId;

    private LocalDate appointmentDate;

    private String status;


}