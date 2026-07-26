package com.hospital.service;


import com.hospital.model.Appointment;
import com.hospital.model.AppointmentRequest;
import com.hospital.model.Doctor;
import com.hospital.model.Patient;
import com.hospital.repo.AppointmentRepository;
import com.hospital.repo.DoctorRepo;
import com.hospital.repo.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired

    private PatientRepo patientRepository;

    @Autowired
    private DoctorRepo doctorRepository;

    public Appointment bookAppointment(AppointmentRequest appointmentRequest) {

        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient Not found"));

        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor id Not found"));

        Appointment appointment = new Appointment();
        appointment.setPatientId(patient);
        appointment.setDoctorId(doctor);
        appointment.setAppointmentDate(appointmentRequest.getAppointmentDate());
        appointment.setStatus("BOOKED");

        return appointmentRepository.save(appointment);
    }

    public Appointment completeAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appoint Id not found"));
        appointment.setStatus("COMPLETED");
        return appointmentRepository.save(appointment);
    }


}
