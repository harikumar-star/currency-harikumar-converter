package com.hospital.model;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AppointmentRequest {

    private Long patientId;
    private Long doctorId;
    private LocalDate appointmentDate;
}
