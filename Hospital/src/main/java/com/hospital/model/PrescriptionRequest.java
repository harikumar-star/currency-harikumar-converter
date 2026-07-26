package com.hospital.model;

import lombok.Data;

@Data
public class PrescriptionRequest {

    private Long appointmentId;
    private String medicineName;
    private Double price;
    private Integer quantity;
}