package com.codingshuttle.HospitalManagement.repository;

import com.codingshuttle.HospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Long> {
}
