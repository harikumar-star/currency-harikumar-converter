package com.hospital.service;

import com.hospital.model.Appointment;
import com.hospital.model.Prescription;
import com.hospital.model.PrescriptionRequest;
import com.hospital.repo.AppointmentRepository;
import com.hospital.repo.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private  PrescriptionRepository prescriptionRepository;
    @Autowired
    private  AppointmentRepository appointmentRepository;

    public Prescription createPrescription(PrescriptionRequest request) {

        Appointment appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        if (!appointment.getStatus().equals("COMPLETED")) {
            throw new RuntimeException("Appointment is not completed");
        }

        double total = request.getPrice() * request.getQuantity();

        Prescription prescription = new Prescription();

        prescription.setAppointment(appointment);
        prescription.setMedicineName(request.getMedicineName());
        prescription.setPrice(request.getPrice());
        prescription.setQuantity(request.getQuantity());
        prescription.setTotalAmount(total);

        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }
}