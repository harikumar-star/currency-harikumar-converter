package com.hospital;

import com.hospital.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);
        // get Patient bean from context
       /* Patient patient = context.getBean(Patient.class);
        patient.setName("harikumar");
        // print name
        System.out.println("Patient Name: " + patient.getName());*/
    }

    }





