package com.prueba.prueba.tecniuca.domain.entity;

import java.time.LocalDateTime;

public class Appointment {
    private long id;
    private Doctor doctor;
    private Patient patient;
    private LocalDateTime date;

    public Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime date){
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
