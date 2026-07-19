package com.codingshuttle.HospitalManagement.Entity;

import jakarta.persistence.*;
@Entity
public class Insurance {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String provider;

    // OWNING SIDE
    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public void setPatient(Patient patient) {
    }
}

