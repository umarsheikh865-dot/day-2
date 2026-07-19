package com.codingshuttle.HospitalManagement.Repository;

import com.codingshuttle.HospitalManagement.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
