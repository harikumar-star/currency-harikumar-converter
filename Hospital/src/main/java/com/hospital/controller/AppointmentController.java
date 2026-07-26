package com.hospital.controller;


import com.hospital.model.Appointment;
import com.hospital.model.AppointmentRequest;
import com.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment appointment(@RequestBody AppointmentRequest appointmentRequest){
        return appointmentService.bookAppointment(appointmentRequest);
    }

    @PutMapping("/{id}/complete")
    public Appointment appointment(@PathVariable Long id){
        return appointmentService.completeAppointment(id);
    }

}
