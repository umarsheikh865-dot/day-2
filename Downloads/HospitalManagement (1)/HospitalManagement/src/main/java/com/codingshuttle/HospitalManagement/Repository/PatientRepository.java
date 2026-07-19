package com.codingshuttle.HospitalManagement.Repository;

import com.codingshuttle.HospitalManagement.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("""
           SELECT p FROM Patient p
           LEFT JOIN FETCH p.appointments
           """)
    List<Patient> findAllWithAppointments();


}
