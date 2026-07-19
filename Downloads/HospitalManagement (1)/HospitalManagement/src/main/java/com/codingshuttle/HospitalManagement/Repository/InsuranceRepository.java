package com.codingshuttle.HospitalManagement.Repository;

import com.codingshuttle.HospitalManagement.Entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
