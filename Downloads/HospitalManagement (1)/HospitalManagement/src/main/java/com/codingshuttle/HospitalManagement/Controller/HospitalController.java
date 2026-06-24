package com.codingshuttle.HospitalManagement.Controller;

import com.codingshuttle.HospitalManagement.Entity.Insurance;
import com.codingshuttle.HospitalManagement.Entity.Patient;
import com.codingshuttle.HospitalManagement.Service.Hospitalservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    @Autowired
    private Hospitalservice hospitalservice;

    // Add insurance to a patient
    @PostMapping("/insurance/{patientId}")
    public String addInsurance(
            @PathVariable Long patientId,
            @RequestBody Insurance insurance) {

        hospitalservice.addInsurance(patientId, insurance);

        return "Insurance added successfully";
    }

    // Create appointment between patient and doctor
    @PostMapping("/appointment")
    public String createAppointment(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam String time) {

        hospitalservice.createAppointment(
                patientId,
                doctorId,
                time
        );

        return "Appointment created successfully";
    }

    // Test N+1 Optimization
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {

        return hospitalservice.getPatientsWithAppointments();
    }
}