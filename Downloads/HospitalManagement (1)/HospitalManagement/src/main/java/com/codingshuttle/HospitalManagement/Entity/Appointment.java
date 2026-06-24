package com.codingshuttle.HospitalManagement.Entity;

import jakarta.persistence.*;
import lombok.*; // Assuming you are using Lombok as per your previous code

@Entity
@Getter @Setter // These will automatically create the setTime, setPatient, etc.
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String time;

    // MANY TO ONE (OWNING SIDE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}