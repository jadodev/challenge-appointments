package com.prueba.prueba.tecniuca.application.service;

import java.time.LocalDateTime;

public class AppointmentRequest {
    private Long doctorId;
    private String doctorName;
    private String doctorSpeciality;
    private Long patientId;
    private String patientName;
    private LocalDateTime dateTime;

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