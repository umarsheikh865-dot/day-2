package com.codingshuttle.HospitalManagement.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Entity
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    // ONE TO ONE (Inverse Side)
    @OneToOne(mappedBy = "patient",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Insurance insurance;

    // ONE TO MANY
    @OneToMany(mappedBy = "patient",
            cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    public Collection<Appointment> getAppointments() {

        return List.of();
    }

    public void setInsurance(Insurance insurance) {
    }
}
