package com.prueba.prueba.tecniuca.infrastructure.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long doctorId;
    private String doctorName;
    private String doctorSpeciality;

    private Long patientId;
    private String patientName;

    private LocalDateTime dateTime;

    public AppointmentEntity() {}

    public AppointmentEntity(Long id, Long doctorId, String doctorName, String doctorSpeciality,
                             Long patientId, String patientName, LocalDateTime dateTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorSpeciality = doctorSpeciality;
        this.patientId = patientId;
        this.patientName = patientName;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
    }

    public Long getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

