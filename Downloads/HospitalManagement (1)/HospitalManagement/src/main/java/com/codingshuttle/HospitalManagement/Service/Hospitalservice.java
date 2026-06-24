package com.codingshuttle.HospitalManagement.Service;

import com.codingshuttle.HospitalManagement.Entity.Appointment;
import com.codingshuttle.HospitalManagement.Entity.Doctor;
import com.codingshuttle.HospitalManagement.Entity.Insurance;
import com.codingshuttle.HospitalManagement.Entity.Patient;
import com.codingshuttle.HospitalManagement.Repository.AppointmentRepository;
import com.codingshuttle.HospitalManagement.Repository.DoctorRepository;
import com.codingshuttle.HospitalManagement.Repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class Hospitalservice {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // ASSIGN INSURANCE
    public void addInsurance(Long patientId, Insurance insurance) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();

        insurance.setPatient(patient);
        patient.setInsurance(insurance);

        patientRepository.save(patient);
    }

    // CREATE APPOINTMENT
    public void createAppointment(Long patientId, Long doctorId, String time) {

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();

        Appointment app = new Appointment();
        app.setTime(time);
        app.setPatient(patient);
        app.setDoctor(doctor);

        patient.getAppointments().add(app);
        doctor.getAppoinments().add(app);

        appointmentRepository.save(app);
    }

    // N+1 FIX QUERY
    public List<Patient> getPatientsWithAppointments() {
        return patientRepository.findAllWithAppointments();
    }
}