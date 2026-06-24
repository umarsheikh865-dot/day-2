package com.codingshuttle.HospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departement { // Ensure this matches your file name

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // INVERSE SIDE
    @ManyToMany(mappedBy = "departments")
    private List<Doctor> doctors = new ArrayList<>();

    public class Department {
    }
}