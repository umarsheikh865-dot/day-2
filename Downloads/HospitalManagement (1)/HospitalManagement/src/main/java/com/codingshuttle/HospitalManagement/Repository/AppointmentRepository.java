package com.codingshuttle.HospitalManagement.Repository;

import com.codingshuttle.HospitalManagement.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
