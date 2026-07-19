package com.codingshuttle.HospitalManagement.Repository;

import com.codingshuttle.HospitalManagement.Entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departement, Long> {
}
